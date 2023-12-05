create or replace function validaChavePessoaFornecedor()
	returns trigger
	language plpgsql
as $$
declare existe integer;

begin
	existe = (select count(1) from pessoa_fisica pf where id = new.pessoa_forn_id);
	if(existe <= 0) then
			existe = (select count(1) from pessoa_juridica pj where id = new.pessoa_forn_id);
		if(existe <= 0) then
			raise exception 'Não foi encontrado o id e pk da pessoa para realizar a associação do cadastro';
		end if;
	end if;
return new;
end;
$$