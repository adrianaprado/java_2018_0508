<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../includes/header.jsp" %>

    <div class="contenedor">

		<%@ include file="../includes/navbar.jsp" %>

        <main class="container" role="main">
	
            <h1><i class="fas fa-clipboard-list"></i> Listado de productos</h1>
                
            <table id="listado-productos" class="display">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Precio</th>
                        <th>Stock</th>
                        <th>Descuento</th>
                        <th>Precio / Litro</th>
                        <th>Descripción</th>
                        <th>Imagen (URL)</th>
                    </tr>
                </thead>

                <tbody>
                    
                    <tr>
                        <td>Beefeater</td>
                        <td>12.95&euro;</td>
                        <td>25</td>
                        <td>20&#37;</td>
                        <td>18.50&euro; / L</td>
                        <td>BEEFEATER ginebra inglesa botella 70cl.</td>
                        <td><img src="https://supermercado.eroski.es/images/313577.jpg" alt="imagen-ginebra-beefeater" /></td>
                    </tr>
                        
                    <tr>
                        <td>Don SimÃ³n</td>
                        <td>1.75&euro;</td>
                        <td>176</td>
                        <td>5&#37;</td>
                        <td>2.15&euro; / L</td>
                        <td>Vino tinto 12 % vol alcohol. Clarificado y estabilizado. Franco y limpio. MicrobiolÃ³gicamente estable.</td>
                        <td><img src="https://s2.dia.es/medias/h83/h57/9158836420638.jpg" alt="imagen-vino-don-simon" /></td>
                    </tr>
                        
                    <tr>
                        <td>Absolut Vodka</td>
                        <td>15.75&euro;</td>
                        <td>17</td>
                        <td>0&#37;</td>
                        <td>19.95&euro; / L</td>
                        <td>Absolut Vodka es la marca lÃ­der de vodka Premium, con el autÃ©ntico sabor del vodka original o tus sabores favoritos elaborados con ingredientes naturales.</td>
                        <td><img src="https://www.oaksncorks.com/wp-content/uploads/2017/04/absolut-vodka-100x100.png" alt="imagen-absolute-vodka" /></td>
                    </tr>
                        
                    <tr>
                        <td>Johnnie Walker (Blue Label)</td>
                        <td>22.95&euro;</td>
                        <td>34</td>
                        <td>33&#37;</td>
                        <td>27.50&euro; / L</td>
                        <td>Johnnie Walkerâ es una marca de whisky escocÃ©s producida por Diageo en Kilmarnock, Escocia.</td>
                        <td><img src="https://cdn.shopify.com/s/files/1/0213/9218/products/johnnie-walker-blue-label.jpg?v=1499156537" alt="imagen-whisky-johnny-walker" /></td>
                    </tr>
                        
                    <tr>
                        <td>Santa Teresa</td>
                        <td>17.95&euro;</td>
                        <td>76</td>
                        <td>0&#37;</td>
                        <td>20.50&euro; / L</td>
                        <td>Con una mezcla de rones Premium y hasta cinco años en barriles y barricas de roble, Santa Teresa Gran Reserva es la joya de la corona de los rones.</td>
                        <td><img src="https://sgfm.elcorteingles.es/SGFM/dctm/MEDIA03/201807/03/00118733300539____2__600x600.jpg" alt="imagen-ron-santa-teresa" /></td>
                    </tr>
                        
                    <tr>
                        <td>Paulaner</td>
                        <td>2.95&euro;</td>
                        <td>92</td>
                        <td>10&#37;</td>
                        <td>5.35&euro; / L</td>
                        <td>Como marca líder de cerveza de trigo, la Cervecería Paulaner asume responsabilidad y aboga por un consumo responsable de bebidas alcohÃ³licas.</td>
                        <td><img src="https://souriredessaveurs.com/2978-large_default/cerveza-hefe-weissbier-paulaner-naturtrueb-aleman-blanco-55-50-cl.jpg" alt="imagen-cerveza-paulaner" /></td>
                    </tr>
                        
                </tbody>

            </table>
            
        </main>

       

    </div> <!-- /.contenedor -->
  <%@ include file="../includes/footer.jsp" %>
    
</body>
</html>