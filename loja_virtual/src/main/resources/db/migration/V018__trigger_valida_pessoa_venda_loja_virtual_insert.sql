create trigger validaChavePessoaInsert
before insert
on venda_compra_loja_virtual
for each row
execute procedure validaChavePessoa();