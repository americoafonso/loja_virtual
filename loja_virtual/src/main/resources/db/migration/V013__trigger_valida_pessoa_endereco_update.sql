create trigger validaChavePessoaUpdate
before update
on endereco
for each row
execute procedure validaChavePessoa();