create trigger validaChavePessoaAvaliacaoContaPagarUpdate
before update
on conta_pagar
for each row
execute procedure validaChavePessoa();