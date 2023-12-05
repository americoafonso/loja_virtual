create trigger validaChavePessoaFornecedorUpdate
before update
on conta_pagar
for each row
execute procedure validaChavePessoaFornecedor();