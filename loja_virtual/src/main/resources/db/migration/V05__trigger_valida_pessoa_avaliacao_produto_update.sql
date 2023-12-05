create trigger validaChavePessoaAvaliacaoProdutoUpdate
before update
on avaliacao_produto
for each row
execute procedure validaChavePessoa();