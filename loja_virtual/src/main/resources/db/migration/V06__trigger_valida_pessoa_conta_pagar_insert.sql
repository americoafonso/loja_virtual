create trigger validaChavePessoaAvaliacaoContaPagarInsert
before insert
on conta_pagar
for each row
execute procedure validaChavePessoa();