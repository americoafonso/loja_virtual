create trigger validaChavePessoaUpdate
before update
on usuario
for each row
execute procedure validaChavePessoa();