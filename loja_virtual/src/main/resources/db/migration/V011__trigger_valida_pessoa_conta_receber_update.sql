create trigger validaChavePessoaUpdate
before update
on conta_receber
for each row
execute procedure validaChavePessoa();