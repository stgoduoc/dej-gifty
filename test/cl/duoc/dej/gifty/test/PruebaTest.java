package cl.duoc.dej.gifty.test;

import cl.duoc.dej.gifty.entity.Categoria;
import cl.duoc.dej.gifty.service.CategoriaService;
import cl.duoc.dej.gifty.service.Conexion;
import cl.duoc.dej.gifty.service.SetupService;
import java.sql.Connection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LC1300XXXX
 */
public class PruebaTest {
    
    Connection conexion;
    SetupService setupService;
    CategoriaService categoriaService;
    
    public PruebaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        conexion = Conexion.getConexion("test");
        setupService = new SetupService();
        setupService.setConexion(conexion);
        setupService.instalar();
        
        categoriaService = new CategoriaService();
        categoriaService.setConexion(conexion);
    }
    
    @After
    public void tearDown() {
        setupService.desinstalar();
    }

    @Test
    public void cargarDatos() {
        Categoria categoria = new Categoria("categoria de prueba");
        categoriaService.crearCategoria(categoria);
        List<Categoria> listaCategorias = categoriaService.getCategorias();
        assert listaCategorias.size() == 1;
    }
}
