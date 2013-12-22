package mma.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by Maciek on 22.12.13.
 */
public class XMLUtils {

    public static <T> void saveObject(T object, Class<T> typeClass, URL path) {
        try {
            File file = new File(path.toURI());
            JAXBContext jaxbContext = JAXBContext.newInstance(typeClass);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(object, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static <T> void saveObject(T object, Class<T> typeClass, String path) {
        try {
            File file = new File(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(typeClass);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(object, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static <T> T loadObject(Class<T> typeClass, URL path) {
        T object = null;

        try {
            File file = new File(path.toURI());
            JAXBContext jaxbContext = JAXBContext.newInstance(typeClass);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            object = (T) jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return object;
    }
}
