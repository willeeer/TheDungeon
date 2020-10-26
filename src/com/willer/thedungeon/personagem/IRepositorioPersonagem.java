package com.willer.thedungeon.personagem;

public interface IRepositorioPersonagem
{

   public boolean inserir(Personagem p);

   public Personagem buscarPorId(Integer id);

   public void excluir(Integer id);

}
