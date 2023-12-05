create trigger validaChavePessoaInsert
before insert
on nota_fiscal_compra
for each row
execute procedure validaChavePessoa();