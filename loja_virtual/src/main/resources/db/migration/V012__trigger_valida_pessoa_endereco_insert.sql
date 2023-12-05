create trigger validaChavePessoaInsert
before insert
on endereco
for each row
execute procedure validaChavePessoa();