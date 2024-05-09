package Amoa.server;

import javax.xml.ws.Endpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Amoa.webservices.ProductsManagerImpl;
import javax.jws.WebService;
import javax.xml.ws.Provider;

@WebService
public class ServicePublisher implements Provider<ProductsManagerImpl> {
    private static Logger logger = LoggerFactory.getLogger(ServicePublisher.class);

    public static void main(String[] args) {
        logger.info("Starting server");
        Endpoint.publish("http://localhost:2020/webservices/ProductsManager", new ServicePublisher());
        logger.info("Server started");
    }
}
