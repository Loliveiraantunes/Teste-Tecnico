package dao;

import java.util.List;
import model.Livro;

/**
 *
 * @author loliv
 */
public interface Base {
    
    List<Livro> ordenarAscPorTitulo(List<Livro> list);
    
    List<Livro> ordenarDescPorTitulo(List<Livro> list);
    
    List<Livro> ordenarAscPorAutor(List<Livro> list);
    
    List<Livro> ordenarDescPorAutor(List<Livro> list);
     
    List<Livro> ordernarAscPorEdicao(List<Livro> list);
    
     List<Livro> ordernarDescPorEdicao(List<Livro> list);
    
}
