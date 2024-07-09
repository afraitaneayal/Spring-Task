package com.example.demo.reporting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.demo.purchase.Purchase;
import com.example.demo.purchase.PurchaseRepository;
import com.example.demo.refund.Refund;
import com.example.demo.refund.RefundRepository;

@Component
public class DailyReportJob {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private RefundRepository refundRepository;

    @Value("${spring.email.to}")
    private String recipientEmail;

    @Scheduled(cron = "0 0 1 * * ?")
    public void sendDailyReport() {
        LocalDate yesterday = LocalDate.now().minusDays(1);
        LocalDateTime startOfDay = yesterday.atStartOfDay();
        LocalDateTime endOfDay = yesterday.atTime(LocalTime.MAX);

        List<Purchase> purchases = purchaseRepository.findByDateBetween(startOfDay, endOfDay);
        List<Refund> refunds = refundRepository.findByDateBetween(startOfDay, endOfDay);

        StringBuilder emailContent = new StringBuilder();
        emailContent.append("<h1>Daily Report for ").append(yesterday).append("</h1>");
        emailContent.append("<h2>Purchases</h2>");
        emailContent.append("<table border='1'><tr><th>ID</th><th>Customer</th><th>Product</th><th>Amount</th></tr>");
        for (Purchase purchase : purchases) {
            emailContent.append("<tr><td>").append(purchase.getId()).append("</td><td>")
                        .append(purchase.getCustomer().getName()).append("</td><td>")
                        .append(purchase.getProduct().getName()).append("</td><td>")
                        .append(purchase.getAmount()).append("</td></tr>");
        }
        emailContent.append("</table>");
        emailContent.append("<h2>Refunds</h2>");
        emailContent.append("<table border='1'><tr><th>ID</th><th>Customer</th><th>Product</th><th>Amount</th></tr>");
        for (Refund refund : refunds) {
            emailContent.append("<tr><td>").append(refund.getId()).append("</td><td>")
                        .append(refund.getCustomer().getName()).append("</td><td>")
                        .append(refund.getProduct().getName()).append("</td><td>")
                        .append(refund.getAmount()).append("</td></tr>");
        }
        emailContent.append("</table>");

        sendEmail("Daily Report", emailContent.toString());
    }

    private void sendEmail(String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject(subject);
        message.setText(content);
        mailSender.send(message);
    }
}


