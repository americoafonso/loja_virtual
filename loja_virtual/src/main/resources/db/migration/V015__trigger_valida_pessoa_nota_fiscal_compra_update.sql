create trigger validaChavePessoaUpdate
before update
on nota_fiscal_compra
for each row
execute procedure validaChavePessoa();
