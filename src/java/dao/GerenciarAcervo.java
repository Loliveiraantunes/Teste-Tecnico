package dao;

import Exceptions.OrderingException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.Livro;

public class GerenciarAcervo implements Base {

    static GerenciarAcervo gerenciarAcervo;

    @Override
    public List<Livro> ordenarAscPorTitulo(List<Livro> list) {

        try {
            List<Livro> ascervosFiltrado = list;
            Collections.sort(ascervosFiltrado, new Comparator<Livro>() {
                @Override
                public int compare(Livro livro1, Livro livro2) {
                    return livro1.getTitulo().compareTo(livro2.getTitulo());
                }
            });
            return ascervosFiltrado;
        } catch (Exception e) {
            throw new OrderingException("Erro Lista está Nula.");
        }

    }

    @Override
    public List<Livro> ordenarDescPorTitulo(List list) {
      try{
        List<Livro> ascervosFiltrado = list;
        Collections.sort(ascervosFiltrado, new Comparator<Livro>() {
            @Override
            public int compare(Livro livro1, Livro livro2) {
                return livro2.getTitulo().compareTo(livro1.getTitulo());
            }
        });
        return ascervosFiltrado;
         } catch (Exception e) {
            throw new OrderingException("Erro Lista está Nula.");
        }
    }

    @Override
    public List<Livro> ordenarAscPorAutor(List list) {
      try{
        List<Livro> ascervosFiltrado = list;
        Collections.sort(ascervosFiltrado, new Comparator<Livro>() {
            @Override
            public int compare(Livro livro1, Livro livro2) {
                return livro1.getAutor().compareTo(livro2.getAutor());
            }
        });
        return ascervosFiltrado;
         } catch (Exception e) {
            throw new OrderingException("Erro Lista está Nula.");
        }
    }

    @Override
    public List<Livro> ordenarDescPorAutor(List list) {
       try{
        List<Livro> ascervosFiltrado = list;
        Collections.sort(ascervosFiltrado, new Comparator<Livro>() {
            @Override
            public int compare(Livro livro1, Livro livro2) {
                return livro2.getAutor().compareTo(livro1.getAutor());
            }
        });
        return ascervosFiltrado;
         } catch (Exception e) {
            throw new OrderingException("Erro Lista está Nula.");
        }
    }

    @Override
    public List<Livro> ordernarAscPorEdicao(List list) {
        try{
        List<Livro> ascervosFiltrado = list;
        Collections.sort(ascervosFiltrado, new Comparator<Livro>() {
            @Override
            public int compare(Livro livro1, Livro livro2) {
                return livro1.getEdicao().compareTo(livro2.getEdicao());
            }
        });
        return ascervosFiltrado;
         } catch (Exception e) {
            throw new OrderingException("Erro Lista está Nula.");
        }
    }

    @Override
    public List<Livro> ordernarDescPorEdicao(List list) {
        try{
        List<Livro> ascervosFiltrado = list;
        Collections.sort(ascervosFiltrado, new Comparator<Livro>() {
            @Override
            public int compare(Livro livro1, Livro livro2) {
                return livro2.getEdicao().compareTo(livro1.getEdicao());
            }
        });
        return ascervosFiltrado;
         } catch (Exception e) {
            throw new OrderingException("Erro Lista está Nula.");
        }
    }

    public static GerenciarAcervo getInstance() {
        if (gerenciarAcervo == null) {
            gerenciarAcervo = new GerenciarAcervo();
        }
        return gerenciarAcervo;
    }

}
