package com.willer.thedungeon.personagem;

import com.willer.thedungeon.exceptions.RepositorioException;

public interface IRepositorioPersonagem
{

   public void inserir(Personagem p) throws RepositorioException;

   public Personagem buscarPorId(Integer id);

   public void excluir(Integer id);

}
