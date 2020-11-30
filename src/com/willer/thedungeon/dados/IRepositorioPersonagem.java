package com.willer.thedungeon.dados;

import com.willer.thedungeon.exceptions.RepositorioException;
import com.willer.thedungeon.geral.personagem.Personagem;

public interface IRepositorioPersonagem
{

   public void inserir(Personagem p) throws RepositorioException;

   public Personagem buscarPorId(Integer id);

   public void excluir(Integer id);

}
