create trigger validaChavePessoaUpdate
before update
on venda_compra_loja_virtual
for each row
execute procedure validaChavePessoa();