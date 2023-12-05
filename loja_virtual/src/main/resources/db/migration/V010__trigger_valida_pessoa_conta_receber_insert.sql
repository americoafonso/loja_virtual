create trigger validaChavePessoaInsert
before insert
on conta_receber
for each row
execute procedure validaChavePessoa();