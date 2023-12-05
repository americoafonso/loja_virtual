create trigger validaChavePessoaInsert
before insert
on usuario
for each row
execute procedure validaChavePessoa();