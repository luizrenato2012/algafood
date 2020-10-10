/** cozinhas */
insert into cozinha (id, nome) value (1, "Tailândesa")
insert into cozinha (id, nome) value (2, "Indiana")

/** restaurantes */
insert into restaurante (nome, taxa_frete, cozinha_id) value ("La Traviata", 5.33, 1)
insert into restaurante (nome, taxa_frete, cozinha_id) value ("Tempero Bom", 3.5, 2)
/** forma de pagamento */

insert into forma_pagamento (descricao) value ('Débito')
insert into forma_pagamento (descricao) value ('Crédito')
insert into forma_pagamento (descricao) value ('Dinheiro')

/** Permissao*/
insert into permissao (nome, descricao) value ('ListarCozinha', 'Permite listar cozinha')
insert into permissao (nome, descricao) value ('AlterarCozinha', 'Permite alterar cozinha')
insert into permissao (nome, descricao) value ('ListarRestaurante', 'Permite listar restaurante')
insert into permissao (nome, descricao) value ('AlterarRestaurante', 'Permite alterar restaurante')

/** Estado */
insert into estado (id, nome) value (1, 'Amazonas')
insert into estado (id, nome) value (2, 'Amapa')
insert into estado (id, nome) value (3, 'Acre')
insert into estado (id, nome) value (4, 'Bahia')
insert into estado (id, nome) value (5, 'Ceará')
insert into estado (id, nome) value (6, 'Distrito Federal')

/** Cidade */
insert into cidade (nome, estado_id) value ('Ceilandia',  6)
insert into cidade (nome, estado_id) value ('Taguatinga', 6 )
insert into cidade (nome, estado_id) value ('Ananindeua', 6)
insert into cidade (nome, estado_id) value ('Manaus', 1)
insert into cidade (nome, estado_id) value ('porto Seguro', 4)
