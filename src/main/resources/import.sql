    INSERT INTO tb_categoria(id, nome) VALUES(categoria_seq.NEXTVAL, 'Alimetos');
    INSERT INTO tb_categoria(id, nome) VALUES(categoria_seq.NEXTVAL, 'Componentes Ritualisticos');
    INSERT INTO tb_categoria(id, nome) VALUES(categoria_seq.NEXTVAL, 'Ferramentas');
    INSERT INTO tb_categoria(id, nome) VALUES(categoria_seq.NEXTVAL, 'Eletrônicos');
    INSERT INTO tb_categoria(id, nome) VALUES(categoria_seq.NEXTVAL, 'Lazer');
    INSERT INTO tb_categoria(id, nome) VALUES(categoria_seq.NEXTVAL, 'Bomba Cáustica');

    INSERT INTO tb_produto(id, nome, descricao, valor, categoria_id) VALUES(produto_seq.NEXTVAL, 'Mouse Microsoft', 'Mouse sem fio', 250.0, 5);
    INSERT INTO tb_produto(id, nome, descricao, valor, categoria_id) VALUES(produto_seq.NEXTVAL, 'Smartphone Samsung Galaxy A54 5G', 'Samsung Galaxy A54 5G', 1799.0, 1);
    INSERT INTO tb_produto(id, nome, descricao, valor, categoria_id) VALUES(produto_seq.NEXTVAL, 'Smart TV', 'Smart TV LG LED 65 polegadas', 3999, 2);