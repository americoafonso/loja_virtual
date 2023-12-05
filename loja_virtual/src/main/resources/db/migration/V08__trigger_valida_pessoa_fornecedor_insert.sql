create trigger validaChavePessoaFornecedorInsert
before insert
on conta_pagar
for each row
execute procedure validaChavePessoaFornecedor();