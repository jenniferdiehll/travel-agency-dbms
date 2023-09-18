-- BASIC SELECT


SELECT * FROM ARCHIVE.aviao;
SELECT * FROM ARCHIVE.viagem;
SELECT * FROM ARCHIVE.viagem_voo;
SELECT * FROM ARCHIVE.voo;


SELECT * FROM ARCHIVE.cliente;
SELECT * FROM ARCHIVE.compra;
SELECT * FROM ARCHIVE.ticket;
SELECT * FROM ARCHIVE.reserva;


-- CUSTOMER/PURCHASE CONSULT
SELECT  c.*, co.id_compra, co.valor AS valorCompra, co.data_compra, t.id_ticket
FROM ARCHIVE.cliente c
LEFT JOIN  ARCHIVE.compra co ON c.id_cliente = co.id_cliente
LEFT JOIN ARCHIVE.ticket t ON co.id_compra = t.id_compra;

-- SPECIFIC CUSTOMER/PURCHASE CONSULT
SELECT  c.*, co.id_compra, co.valor AS valorCompra, co.data_compra, t.id_ticket
FROM ARCHIVE.cliente c
LEFT JOIN  ARCHIVE.compra co ON c.id_cliente = co.id_cliente
LEFT JOIN ARCHIVE.ticket t ON co.id_compra = t.id_compra
WHERE c.nome = 'Jennifer Diehl';

-- RESERVED TICKETS CONSULT
SELECT t.*, cl.nome, cl.cpf
FROM ARCHIVE.ticket t
INNER JOIN ARCHIVE.reserva r ON t.id_ticket = r.id_ticket
INNER JOIN ARCHIVE.compra c ON t.id_compra = c.id_compra
INNER JOIN ARCHIVE.cliente cl ON c.id_cliente = cl.id_cliente
WHERE cl.nome = 'Paulo Lanius' AND r.status = 'Reservado';

-- CONSULT OF THE QUANTITY OF PURCHASES MADE FOR A CERTAIN CUSTOMER 
SELECT COUNT(*) AS total_compras
FROM ARCHIVE.cliente c
INNER JOIN ARCHIVE.compra co ON c.id_cliente = co.id_cliente
WHERE c.nome = 'Matheus Moraes Porto';

-- FLIGHT CONSULT FOR A TRIP FROM POA TO PARIS
SELECT v.*
FROM ARCHIVE.viagem_voo vv
JOIN ARCHIVE.viagem vi ON vv.viagem_id = vi.id_viagem
JOIN ARCHIVE.voo v ON vv.voo_id = v.id_voo
WHERE vi.origem = 'POA-PARIS' AND vi.destino = 'PARIS-POA';
