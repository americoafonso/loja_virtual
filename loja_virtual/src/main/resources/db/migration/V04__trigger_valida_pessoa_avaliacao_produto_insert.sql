create trigger validaChavePessoaAvaliacaoProdutoInsert
before insert
on avaliacao_produto
for each row
execute procedure validaChavePessoa();