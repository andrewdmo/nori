--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: catch_hook; Type: TABLE; Schema: public; Owner: katherine_celeste
--

CREATE TABLE catch_hook (
    id bigint NOT NULL,
    cancel_reason character varying(255)
);


ALTER TABLE catch_hook OWNER TO katherine_celeste;

--
-- Name: email_content; Type: TABLE; Schema: public; Owner: katherine_celeste
--

CREATE TABLE email_content (
    id bigint NOT NULL,
    body_field character varying(255),
    from_field character varying(255),
    to_field character varying(255),
    subject_field character varying(255)
);


ALTER TABLE email_content OWNER TO katherine_celeste;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: katherine_celeste
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE hibernate_sequence OWNER TO katherine_celeste;

--
-- Name: level; Type: TABLE; Schema: public; Owner: katherine_celeste
--

CREATE TABLE level (
    id bigint NOT NULL,
    custom_level character varying(255),
    quantity integer,
    qty_levelid bigint
);


ALTER TABLE level OWNER TO katherine_celeste;

--
-- Name: line_item; Type: TABLE; Schema: public; Owner: katherine_celeste
--

CREATE TABLE line_item (
    id bigint NOT NULL,
    product_id bigint,
    quantity integer,
    catch_hookid bigint
);


ALTER TABLE line_item OWNER TO katherine_celeste;

--
-- Name: product; Type: TABLE; Schema: public; Owner: katherine_celeste
--

CREATE TABLE product (
    id bigint NOT NULL,
    title character varying(255),
    vendor character varying(255)
);


ALTER TABLE product OWNER TO katherine_celeste;

--
-- Name: product_image; Type: TABLE; Schema: public; Owner: katherine_celeste
--

CREATE TABLE product_image (
    id bigint NOT NULL,
    src character varying(255),
    productid bigint
);


ALTER TABLE product_image OWNER TO katherine_celeste;

--
-- Name: qty_alert_trigger_level; Type: TABLE; Schema: public; Owner: katherine_celeste
--

CREATE TABLE qty_alert_trigger_level (
    id bigint NOT NULL,
    product_id bigint,
    qty_trigger character varying(255)
);


ALTER TABLE qty_alert_trigger_level OWNER TO katherine_celeste;

--
-- Name: qty_level; Type: TABLE; Schema: public; Owner: katherine_celeste
--

CREATE TABLE qty_level (
    id bigint NOT NULL,
    productid bigint
);


ALTER TABLE qty_level OWNER TO katherine_celeste;

--
-- Name: users; Type: TABLE; Schema: public; Owner: katherine_celeste
--

CREATE TABLE users (
    id bigint NOT NULL,
    email character varying(255),
    firstname character varying(255),
    is_email_verfiy boolean NOT NULL,
    lastname character varying(255),
    password character varying(255),
    email_text_id bigint
);


ALTER TABLE users OWNER TO katherine_celeste;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: katherine_celeste
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO katherine_celeste;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: katherine_celeste
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- Name: variant; Type: TABLE; Schema: public; Owner: katherine_celeste
--

CREATE TABLE variant (
    id bigint NOT NULL,
    inventory_quantity integer,
    productid bigint
);


ALTER TABLE variant OWNER TO katherine_celeste;

--
-- Name: id; Type: DEFAULT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- Data for Name: catch_hook; Type: TABLE DATA; Schema: public; Owner: katherine_celeste
--

COPY catch_hook (id, cancel_reason) FROM stdin;
\.


--
-- Data for Name: email_content; Type: TABLE DATA; Schema: public; Owner: katherine_celeste
--

COPY email_content (id, body_field, from_field, to_field, subject_field) FROM stdin;
712	Hi there!\r\n\r\nMake sure you login to Nori to check on inventory quantities - an alert has been triggered!\r\n\r\nCheers,\r\nNori	kceleste35@gmail.com	peruvianplatafinaalerts@gmail.com	Nori Alert
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: katherine_celeste
--

SELECT pg_catalog.setval('hibernate_sequence', 712, true);


--
-- Data for Name: level; Type: TABLE DATA; Schema: public; Owner: katherine_celeste
--

COPY level (id, custom_level, quantity, qty_levelid) FROM stdin;
708	High	110	707
709	Low	20	707
710	Out	5	707
582	High	30	581
583	Low	20	581
584	Out	10	581
587	High	50	586
588	Low	30	586
589	Out	20	586
391	High	50	390
392	Low	12	390
393	Out	1	390
395	High	10	394
396	Low	3	394
397	Out	1	394
524	High	100	523
525	Low	60	523
526	Out	50	523
403	High	5	402
404	Low	4	402
405	Out	1	402
591	High	100	590
592	Low	79	590
593	Out	5	590
463	High	200	462
464	Low	70	462
465	Out	60	462
467	High	100	466
468	Low	20	466
469	Out	8	466
471	High	34	470
472	Low	2	470
473	Out	1	470
443	High	14	442
444	Low	12	442
445	Out	5	442
479	High	30	478
480	Low	20	478
481	Out	10	478
483	High	100	482
484	Low	60	482
485	Out	50	482
528	High	100	527
529	Low	90	527
530	Out	82	527
532	High	20	531
533	Low	10	531
534	Out	8	531
595	High	20	594
596	Low	11	594
597	Out	5	594
541	High	100	540
542	Low	15	540
543	Out	5	540
545	High	44	544
546	Low	40	544
547	Out	10	544
652	High	400	651
653	Low	300	651
654	Out	201	651
\.


--
-- Data for Name: line_item; Type: TABLE DATA; Schema: public; Owner: katherine_celeste
--

COPY line_item (id, product_id, quantity, catch_hookid) FROM stdin;
\.


--
-- Data for Name: product; Type: TABLE DATA; Schema: public; Owner: katherine_celeste
--

COPY product (id, title, vendor) FROM stdin;
3709610885	Andean Cross | Sterling Silver Earrings with Black Onyx	Platafina
3710118917	Andean Cross | Sterling Silver Earrings with Chrysocolla	Platafina
3710018437	Andean Spiral | Sterling Silver Earrings	Platafina
3709305157	Ascension | Shell Earrings	Platafina
3709412613	Baby Alpaca Hooded Scarf	Platafina
3709261125	Balanced | Shell Earrings	Platafina
3710027077	Blue Buttons | Sterling Silver Earrings with Sodalite	Platafina
3709799301	Celestial | Sterling Silver Earrings	Platafina
3709989445	Checkered Cross | Sterling Silver Earrings	Platafina
3710109381	Chrysocolla Drops | Sterling Silver Earrings	Platafina
3709897349	Clay Earth | Shell Earrings	Platafina
3709744517	Dawn & Dusk with Mother of Pearl | Sterling Silver Earrings	Platafina
3710039685	Dawn & Dusk | Sterling Silver Earrings	Platafina
3709679685	Dawn & Dusk | Sterling Silver Earrings with Blue Sodalite	Platafina
3709938949	Diamond Cross | Shell Earrings	Platafina
3709808773	Drops of Heaven | Sterling Silver Earrings	Platafina
3709931717	Duality | Shell Earrings	Platafina
3709914757	Emerald Beauty | Shell Earrings	Platafina
3709878981	Hot Tropics | Shell Earrings	Platafina
3709956485	Inca Creator | Sterling Silver Earrings with Chrysocolla	Platafina
3710049541	Inca Sunrise | Sterling Silver Earrings with Mother of Pearl	Platafina
3710079429	Inca Tales | Sterling Silver Earrings	Platafina
3709526597	Inca Tales | Sterling Silver Earrings with Orange Jasper	Platafina
3709968069	Lucky Clover | Sterling Silver Earrings	Platafina
3710127493	Lunar Phases | Sterling Silver Earrings	Platafina
3709947333	Modern Silver | Sterling Silver Earrings	Platafina
3709789829	Orange Jasper Drops | Sterling Silver Earrings	Platafina
3709890821	Purple and Gold | Shell Earrings	Platafina
3708909957	Radiant Tangerine	Platafina
3709979525	Rain Drops | Sterling Silver Earrings	Platafina
3709923781	Red Wave | Shell Earrings	Platafina
3709841925	Royal Pyramid | Shell Earrings	Platafina
3709823877	Signs & Symbols | Shell Earrings	Platafina
3710058885	Silver Buttons | Sterling Silver Earrings	Platafina
3709202309	Sky Tranquility | Shell Earrings	Platafina
3709998981	Square Cut | Sterling Silver Earrings	Platafina
3710068869	Square Spirit | Sterling Silver Earrings with Chrysocolla	Platafina
3709866181	Suenos Rosados | Shell Earrings	Platafina
3709854789	Turquoise Double | Shell Earrings	Platafina
3710009285	Vertical Signs | Sterling Silver Earrings	Platafina
3709904901	Violet Fire | Shell Earrings	Platafina
3710089093	Woven Drops | Sterling Silver Earrings	Platafina
3710097093	Woven Hoops | Sterling Silver Earrings	Platafina
\.


--
-- Data for Name: product_image; Type: TABLE DATA; Schema: public; Owner: katherine_celeste
--

COPY product_image (id, src, productid) FROM stdin;
7814648581	https://cdn.shopify.com/s/files/1/0711/7863/products/Andean-Cross-with-Black-Platafina.jpg?v=1455850375	3709610885
7815588613	https://cdn.shopify.com/s/files/1/0711/7863/products/Andean-Cross-Platafina-3.gif?v=1455850375	3710118917
7815323525	https://cdn.shopify.com/s/files/1/0711/7863/products/Andean-Spiral-Platafina2.gif?v=1455850378	3710018437
7814507461	https://cdn.shopify.com/s/files/1/0711/7863/products/Ascension.jpg?v=1455850377	3709305157
7814554949	https://cdn.shopify.com/s/files/1/0711/7863/products/Alpaca-Scarf-With-Symbol-Earrings-11.jpg?v=1455850381	3709412613
7814489861	https://cdn.shopify.com/s/files/1/0711/7863/products/Balanced-Navy.jpg?v=1455850380	3709261125
7815342405	https://cdn.shopify.com/s/files/1/0711/7863/products/Blue-Buttons-Platafina.gif?v=1455850383	3710027077
7814776069	https://cdn.shopify.com/s/files/1/0711/7863/products/Celestial-Platafina.jpg?v=1455850385	3709799301
7815239877	https://cdn.shopify.com/s/files/1/0711/7863/products/Checkered-Cross-Platafina2.gif?v=1455850395	3709989445
7815554053	https://cdn.shopify.com/s/files/1/0711/7863/products/Aventurine-Drops-Platafinaside.gif?v=1455850388	3710109381
7815004741	https://cdn.shopify.com/s/files/1/0711/7863/products/Clay-Earth-Platafina.jpg?v=1455850392	3709897349
7814719237	https://cdn.shopify.com/s/files/1/0711/7863/products/Dawn-Dusk-with-Mother-of-Pearl-Platafina.jpg?v=1455850390	3709744517
7815374725	https://cdn.shopify.com/s/files/1/0711/7863/products/DawnAndDusk-Platafina.gif?v=1455850397	3710039685
7814682885	https://cdn.shopify.com/s/files/1/0711/7863/products/dawn-and-dusk.jpg?v=1455850393	3709679685
7815118597	https://cdn.shopify.com/s/files/1/0711/7863/products/Diamond-Cross-Platafina.jpg?v=1455850401	3709938949
7814801029	https://cdn.shopify.com/s/files/1/0711/7863/products/Drops-of-Heaven-Platafina.jpg?v=1455850399	3709808773
7815098757	https://cdn.shopify.com/s/files/1/0711/7863/products/Black-and-White.jpg?v=1455850403	3709931717
7815056709	https://cdn.shopify.com/s/files/1/0711/7863/products/Emerald-Beauty.jpg?v=1455850410	3709914757
7814950661	https://cdn.shopify.com/s/files/1/0711/7863/products/Hot-Tropics.jpg?v=1455850407	3709878981
7815155589	https://cdn.shopify.com/s/files/1/0711/7863/products/Inca-Creator-Platafina.jpg?v=1455850415	3709956485
7815401477	https://cdn.shopify.com/s/files/1/0711/7863/products/Inca-Sunrise-Platafina.gif?v=1455850405	3710049541
7815483013	https://cdn.shopify.com/s/files/1/0711/7863/products/Inca-Tales-2.gif?v=1455850412	3710079429
7814605189	https://cdn.shopify.com/s/files/1/0711/7863/products/Inca-Tales-with-Purple-Platafina.jpg?v=1455850418	3709526597
7815187333	https://cdn.shopify.com/s/files/1/0711/7863/products/Lucky-Clover-Platafina4.gif?v=1455850420	3709968069
7815611717	https://cdn.shopify.com/s/files/1/0711/7863/products/Platafina02.gif?v=1455850424	3710127493
7815134021	https://cdn.shopify.com/s/files/1/0711/7863/products/Modern-Silver-Platafina.jpg?v=1455850426	3709947333
7814753349	https://cdn.shopify.com/s/files/1/0711/7863/products/Orange-Drops-Platafina.jpg?v=1455850429	3709789829
7814980357	https://cdn.shopify.com/s/files/1/0711/7863/products/Purple-Gold.jpg?v=1455850432	3709890821
7814340229	https://cdn.shopify.com/s/files/1/0711/7863/products/Radiant-Tangerine.jpg?v=1455850441	3708909957
7815215429	https://cdn.shopify.com/s/files/1/0711/7863/products/Rain-Drops-Platafina.gif?v=1455850446	3709979525
7815079941	https://cdn.shopify.com/s/files/1/0711/7863/products/Red-Wave-Platafina.jpg?v=1455850437	3709923781
7814874053	https://cdn.shopify.com/s/files/1/0711/7863/products/Royal-Pyramid-Platafina.jpg?v=1455850435	3709841925
7814834501	https://cdn.shopify.com/s/files/1/0711/7863/products/Signs-Symbols-Platafina.jpg?v=1455850439	3709823877
7815423941	https://cdn.shopify.com/s/files/1/0711/7863/products/Silver-Buttons.gif?v=1455850443	3710058885
7814466181	https://cdn.shopify.com/s/files/1/0711/7863/products/Blue-Tranquility.jpg?v=1455850449	3709202309
7815271941	https://cdn.shopify.com/s/files/1/0711/7863/products/Square-Cut-Platafina2.gif?v=1455850457	3709998981
7815452677	https://cdn.shopify.com/s/files/1/0711/7863/products/Square-Spirit-Platafina.gif?v=1455850451	3710068869
7814924037	https://cdn.shopify.com/s/files/1/0711/7863/products/Suenos-Rosados-Platafina.jpg?v=1455850467	3709866181
7814902021	https://cdn.shopify.com/s/files/1/0711/7863/products/Turquoise-Double.jpg?v=1455850454	3709854789
7815298629	https://cdn.shopify.com/s/files/1/0711/7863/products/Vertical-Signs-Platafina11.jpg?v=1455850465	3710009285
7815030917	https://cdn.shopify.com/s/files/1/0711/7863/products/Violet-Fire-Platafina.jpg?v=1455850460	3709904901
7815505733	https://cdn.shopify.com/s/files/1/0711/7863/products/Woven-Silver-Drops-Platafina.gif?v=1455850470	3710089093
7815526981	https://cdn.shopify.com/s/files/1/0711/7863/products/Woven-Hoops-Platafina.gif?v=1455850472	3710097093
\.


--
-- Data for Name: qty_alert_trigger_level; Type: TABLE DATA; Schema: public; Owner: katherine_celeste
--

COPY qty_alert_trigger_level (id, product_id, qty_trigger) FROM stdin;
711	3710118917	Out
577	3709808773	Out
578	3709938949	Out
585	3709989445	High
599	3709744517	High
601	3709799301	Out
610	3709261125	High
629	3709305157	High
631	3710027077	High
634	3709412613	High
638	3710018437	High
639	3709897349	Low
647	3709878981	Out
656	3709610885	Out
\.


--
-- Data for Name: qty_level; Type: TABLE DATA; Schema: public; Owner: katherine_celeste
--

COPY qty_level (id, productid) FROM stdin;
390	3709305157
394	3709261125
402	3710027077
442	3709412613
462	3709799301
466	3710109381
470	3709744517
478	3709679685
482	3709938949
523	3709931717
527	3709878981
531	3710058885
540	3709947333
544	3710018437
581	3709989445
586	3709897349
590	3710039685
594	3709808773
651	3709610885
707	3710118917
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: katherine_celeste
--

COPY users (id, email, firstname, is_email_verfiy, lastname, password, email_text_id) FROM stdin;
10	kceleste35@gmail.com	Sample	f	User	$2a$10$5A07cgO96x5UmFR1ka2uEeNl14GTGQcr4B3ssiu3aWA2dIfEiSXTS	\N
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: katherine_celeste
--

SELECT pg_catalog.setval('users_id_seq', 10, true);


--
-- Data for Name: variant; Type: TABLE DATA; Schema: public; Owner: katherine_celeste
--

COPY variant (id, inventory_quantity, productid) FROM stdin;
10909323205	50	3709305157
10909264581	13	3709261125
10910602437	32	3709989445
10910973061	8	3710109381
10910306693	30	3709897349
10910726725	78	3710039685
10909817925	47	3709679685
10910413893	40	3709938949
10910042693	10	3709808773
10910394949	45	3709931717
10910354117	9	3709914757
10910197317	82	3709878981
10910755077	75	3710049541
10910891909	49	3710079429
10909626693	9	3709526597
10910432005	12	3709947333
10910291717	17	3709890821
10908809221	12	3708909957
10910534597	16	3709979525
10910115909	23	3709841925
10910071813	17	3709823877
10910800901	8	3710058885
10910869317	31	3710068869
10910166725	77	3709866181
10910142917	15	3709854789
10910654149	8	3710009285
10910335045	44	3709904901
10910911621	20	3710089093
10909727301	201	3709610885
10910675781	44	3710018437
10909487365	127	3709412613
10910698501	13	3710027077
10910015429	55	3709799301
10909902789	35	3709744517
10910456517	77	3709956485
10910499205	24	3709968069
10911046469	36	3710127493
10909992261	47	3709789829
10910372869	55	3709923781
10909189957	45	3709202309
10910629381	10	3709998981
10910932101	15	3710097093
10911025029	10	3710118917
\.


--
-- Name: catch_hook_pkey; Type: CONSTRAINT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY catch_hook
    ADD CONSTRAINT catch_hook_pkey PRIMARY KEY (id);


--
-- Name: email_content_pkey; Type: CONSTRAINT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY email_content
    ADD CONSTRAINT email_content_pkey PRIMARY KEY (id);


--
-- Name: level_pkey; Type: CONSTRAINT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY level
    ADD CONSTRAINT level_pkey PRIMARY KEY (id);


--
-- Name: line_item_pkey; Type: CONSTRAINT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY line_item
    ADD CONSTRAINT line_item_pkey PRIMARY KEY (id);


--
-- Name: product_image_pkey; Type: CONSTRAINT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY product_image
    ADD CONSTRAINT product_image_pkey PRIMARY KEY (id);


--
-- Name: product_pkey; Type: CONSTRAINT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);


--
-- Name: qty_alert_trigger_level_pkey; Type: CONSTRAINT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY qty_alert_trigger_level
    ADD CONSTRAINT qty_alert_trigger_level_pkey PRIMARY KEY (id);


--
-- Name: qty_level_pkey; Type: CONSTRAINT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY qty_level
    ADD CONSTRAINT qty_level_pkey PRIMARY KEY (id);


--
-- Name: uk_r1es95wqt54hkv314bi8qe7iu; Type: CONSTRAINT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY qty_level
    ADD CONSTRAINT uk_r1es95wqt54hkv314bi8qe7iu UNIQUE (productid);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: variant_pkey; Type: CONSTRAINT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY variant
    ADD CONSTRAINT variant_pkey PRIMARY KEY (id);


--
-- Name: fkecg03djtsogetu94i0r6jsni4; Type: FK CONSTRAINT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY variant
    ADD CONSTRAINT fkecg03djtsogetu94i0r6jsni4 FOREIGN KEY (productid) REFERENCES product(id);


--
-- Name: fkeqep9lcm0xc317xwd61wlricy; Type: FK CONSTRAINT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY level
    ADD CONSTRAINT fkeqep9lcm0xc317xwd61wlricy FOREIGN KEY (qty_levelid) REFERENCES qty_level(id);


--
-- Name: fkk139adrmo1goplqi9tu45rfcc; Type: FK CONSTRAINT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY line_item
    ADD CONSTRAINT fkk139adrmo1goplqi9tu45rfcc FOREIGN KEY (catch_hookid) REFERENCES catch_hook(id);


--
-- Name: fklj6jwhoy4w16ui0eiwvgct789; Type: FK CONSTRAINT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY users
    ADD CONSTRAINT fklj6jwhoy4w16ui0eiwvgct789 FOREIGN KEY (email_text_id) REFERENCES email_content(id);


--
-- Name: fkpndx7xbitglkk8g7dr3quhlxk; Type: FK CONSTRAINT; Schema: public; Owner: katherine_celeste
--

ALTER TABLE ONLY product_image
    ADD CONSTRAINT fkpndx7xbitglkk8g7dr3quhlxk FOREIGN KEY (productid) REFERENCES product(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

