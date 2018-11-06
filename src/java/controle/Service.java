package controle;

import dao.GerenciarAcervo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Livro;

/*
    Classe de Serviço, responsável em captar as informações lançadas pela interface e/ou mandar novamente para interface. 
 */
@WebServlet(name = "service", urlPatterns = {"/app"})
public class Service extends HttpServlet {

    private List<Livro> acervos;
    private GerenciarAcervo gerenciarAcervo;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher requestDispatcher;

    public Service() {
        this.gerenciarAcervo = GerenciarAcervo.getInstance();
    }

    protected void processRequest()
            throws ServletException, IOException {
        String cmd = request.getParameter("c");

        switch (cmd) {
            case "acervos":
                CarregarAcervos();
                break;
            case "filter":
                FiltroDeOrdenacao();
                break;

        }
        requestDispatcher.forward(request, response);
    }

    /*
       Acervo em Memória de Execusão, realizei o teste desta forma para facilitar o teste de maneira que não precise gerar um banco de dados,
       para testar apenas as funcionalidade exigidas no caso de uso.  
    
       Este Método Gera todo o Acervo em uma lista na memoria do computador e envia para a interface do Usuário.
    */
    private void CarregarAcervos() {
        requestDispatcher = request.getRequestDispatcher("index.jsp");
        
        acervos = new ArrayList<>();

        acervos.add(new Livro("Java How To Program", "Deitel & Deitel", "2007"));
        acervos.add(new Livro("Patterns of Enterprise Application Architecture", "Martin Fowler", "2002"));
        acervos.add(new Livro("Head First Design Patterns", "Elisabeth Freeman", "2004"));
        acervos.add(new Livro("Internet & World Wide Web: How to Program", "Deitel & Deitel", "2007"));

        
        request.setAttribute("acervos", acervos);
    }

    private void FiltroDeOrdenacao() {
        requestDispatcher = request.getRequestDispatcher("index.jsp");
        
        CarregarAcervos();
       

        if (request.getParameter("title_filter").equalsIgnoreCase("asc")) {
            this.acervos = this.gerenciarAcervo.ordenarAscPorTitulo(acervos);
        } else if (request.getParameter("title_filter").equalsIgnoreCase("desc")) {
            this.acervos = this.gerenciarAcervo.ordenarDescPorTitulo(acervos);
        }

        if (request.getParameter("autor_filter").equalsIgnoreCase("asc")) {
            this.acervos = this.gerenciarAcervo.ordenarAscPorAutor(acervos);
        } else if (request.getParameter("autor_filter").equalsIgnoreCase("desc")) {
            this.acervos = this.gerenciarAcervo.ordenarDescPorAutor(acervos);
        }

        if (request.getParameter("edicao_filter").equalsIgnoreCase("asc")) {
            this.acervos = this.gerenciarAcervo.ordernarAscPorEdicao(acervos);
        } else if (request.getParameter("edicao_filter").equalsIgnoreCase("desc")) {
            this.acervos = this.gerenciarAcervo.ordernarDescPorEdicao(acervos);
        }

        request.setAttribute("acervos", acervos);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.request = request;
        this.response = response;
        processRequest();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.request = request;
        this.response = response;
        processRequest();
    }


}
