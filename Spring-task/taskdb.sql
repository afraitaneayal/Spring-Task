--
-- PostgreSQL database dump
--

-- Dumped from database version 15.3
-- Dumped by pg_dump version 15.3

-- Started on 2024-07-09 17:26:42

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'SQL_ASCII';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 218 (class 1259 OID 33214)
-- Name: customer; Type: TABLE; Schema: public; Owner: task
--

CREATE TABLE public.customer (
    id bigint NOT NULL,
    name character varying(255),
    phone character varying(255)
);


ALTER TABLE public.customer OWNER TO task;

--
-- TOC entry 214 (class 1259 OID 33210)
-- Name: customer_sequence; Type: SEQUENCE; Schema: public; Owner: task
--

CREATE SEQUENCE public.customer_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.customer_sequence OWNER TO task;

--
-- TOC entry 219 (class 1259 OID 33221)
-- Name: product; Type: TABLE; Schema: public; Owner: task
--

CREATE TABLE public.product (
    id bigint NOT NULL,
    price bigint,
    name character varying(255)
);


ALTER TABLE public.product OWNER TO task;

--
-- TOC entry 215 (class 1259 OID 33211)
-- Name: product_sequence; Type: SEQUENCE; Schema: public; Owner: task
--

CREATE SEQUENCE public.product_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.product_sequence OWNER TO task;

--
-- TOC entry 220 (class 1259 OID 33226)
-- Name: purchase; Type: TABLE; Schema: public; Owner: task
--

CREATE TABLE public.purchase (
    amount bigint,
    customer_id bigint NOT NULL,
    id bigint NOT NULL,
    product_id bigint NOT NULL,
    date timestamp(6) without time zone
);


ALTER TABLE public.purchase OWNER TO task;

--
-- TOC entry 216 (class 1259 OID 33212)
-- Name: purchase_sequence; Type: SEQUENCE; Schema: public; Owner: task
--

CREATE SEQUENCE public.purchase_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.purchase_sequence OWNER TO task;

--
-- TOC entry 221 (class 1259 OID 33231)
-- Name: refund; Type: TABLE; Schema: public; Owner: task
--

CREATE TABLE public.refund (
    amount bigint,
    customer_id bigint NOT NULL,
    id bigint NOT NULL,
    product_id bigint NOT NULL,
    purchase_id bigint NOT NULL,
    date timestamp(6) without time zone
);


ALTER TABLE public.refund OWNER TO task;

--
-- TOC entry 217 (class 1259 OID 33213)
-- Name: refund_sequence; Type: SEQUENCE; Schema: public; Owner: task
--

CREATE SEQUENCE public.refund_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.refund_sequence OWNER TO task;

--
-- TOC entry 3350 (class 0 OID 33214)
-- Dependencies: 218
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: task
--

COPY public.customer (id, name, phone) FROM stdin;
1	Mariam	0152949784
2	Ahmed	345
\.


--
-- TOC entry 3351 (class 0 OID 33221)
-- Dependencies: 219
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: task
--

COPY public.product (id, price, name) FROM stdin;
1	250	juice
\.


--
-- TOC entry 3352 (class 0 OID 33226)
-- Dependencies: 220
-- Data for Name: purchase; Type: TABLE DATA; Schema: public; Owner: task
--

COPY public.purchase (amount, customer_id, id, product_id, date) FROM stdin;
10	1	1	1	\N
2500	1	2	1	2024-07-09 15:34:10.7961
\.


--
-- TOC entry 3353 (class 0 OID 33231)
-- Dependencies: 221
-- Data for Name: refund; Type: TABLE DATA; Schema: public; Owner: task
--

COPY public.refund (amount, customer_id, id, product_id, purchase_id, date) FROM stdin;
100	1	1	1	1	\N
2500	1	2	1	2	2024-07-09 15:35:46.475239
\.


--
-- TOC entry 3359 (class 0 OID 0)
-- Dependencies: 214
-- Name: customer_sequence; Type: SEQUENCE SET; Schema: public; Owner: task
--

SELECT pg_catalog.setval('public.customer_sequence', 2, true);


--
-- TOC entry 3360 (class 0 OID 0)
-- Dependencies: 215
-- Name: product_sequence; Type: SEQUENCE SET; Schema: public; Owner: task
--

SELECT pg_catalog.setval('public.product_sequence', 1, true);


--
-- TOC entry 3361 (class 0 OID 0)
-- Dependencies: 216
-- Name: purchase_sequence; Type: SEQUENCE SET; Schema: public; Owner: task
--

SELECT pg_catalog.setval('public.purchase_sequence', 2, true);


--
-- TOC entry 3362 (class 0 OID 0)
-- Dependencies: 217
-- Name: refund_sequence; Type: SEQUENCE SET; Schema: public; Owner: task
--

SELECT pg_catalog.setval('public.refund_sequence', 2, true);


--
-- TOC entry 3192 (class 2606 OID 33220)
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: task
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);


--
-- TOC entry 3194 (class 2606 OID 33225)
-- Name: product product_pkey; Type: CONSTRAINT; Schema: public; Owner: task
--

ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- TOC entry 3196 (class 2606 OID 33230)
-- Name: purchase purchase_pkey; Type: CONSTRAINT; Schema: public; Owner: task
--

ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT purchase_pkey PRIMARY KEY (id);


--
-- TOC entry 3198 (class 2606 OID 33235)
-- Name: refund refund_pkey; Type: CONSTRAINT; Schema: public; Owner: task
--

ALTER TABLE ONLY public.refund
    ADD CONSTRAINT refund_pkey PRIMARY KEY (id);


--
-- TOC entry 3199 (class 2606 OID 33236)
-- Name: purchase fk2pehe23hwdcyql94c531rbf70; Type: FK CONSTRAINT; Schema: public; Owner: task
--

ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT fk2pehe23hwdcyql94c531rbf70 FOREIGN KEY (customer_id) REFERENCES public.customer(id);


--
-- TOC entry 3200 (class 2606 OID 33241)
-- Name: purchase fk3s4jktret4nl7m8yhfc8mfrn5; Type: FK CONSTRAINT; Schema: public; Owner: task
--

ALTER TABLE ONLY public.purchase
    ADD CONSTRAINT fk3s4jktret4nl7m8yhfc8mfrn5 FOREIGN KEY (product_id) REFERENCES public.product(id);


--
-- TOC entry 3201 (class 2606 OID 33246)
-- Name: refund fk4g7imna3evv9fxup6kdhbm5hu; Type: FK CONSTRAINT; Schema: public; Owner: task
--

ALTER TABLE ONLY public.refund
    ADD CONSTRAINT fk4g7imna3evv9fxup6kdhbm5hu FOREIGN KEY (customer_id) REFERENCES public.customer(id);


--
-- TOC entry 3202 (class 2606 OID 33251)
-- Name: refund fkj07qm8nshwv2m4wr86qc8x8y9; Type: FK CONSTRAINT; Schema: public; Owner: task
--

ALTER TABLE ONLY public.refund
    ADD CONSTRAINT fkj07qm8nshwv2m4wr86qc8x8y9 FOREIGN KEY (product_id) REFERENCES public.product(id);


--
-- TOC entry 3203 (class 2606 OID 33256)
-- Name: refund fkn6hygqb7v8me2nthibetqp245; Type: FK CONSTRAINT; Schema: public; Owner: task
--

ALTER TABLE ONLY public.refund
    ADD CONSTRAINT fkn6hygqb7v8me2nthibetqp245 FOREIGN KEY (purchase_id) REFERENCES public.purchase(id);


--
-- TOC entry 2052 (class 826 OID 24846)
-- Name: DEFAULT PRIVILEGES FOR SEQUENCES; Type: DEFAULT ACL; Schema: -; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres GRANT ALL ON SEQUENCES  TO task;


--
-- TOC entry 2050 (class 826 OID 24844)
-- Name: DEFAULT PRIVILEGES FOR FUNCTIONS; Type: DEFAULT ACL; Schema: -; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres GRANT ALL ON FUNCTIONS  TO task WITH GRANT OPTION;


--
-- TOC entry 2051 (class 826 OID 24845)
-- Name: DEFAULT PRIVILEGES FOR TABLES; Type: DEFAULT ACL; Schema: -; Owner: postgres
--

ALTER DEFAULT PRIVILEGES FOR ROLE postgres GRANT ALL ON TABLES  TO task;


-- Completed on 2024-07-09 17:26:42

--
-- PostgreSQL database dump complete
--

