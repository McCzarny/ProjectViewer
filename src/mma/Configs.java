package mma;

import mma.interfaces.ProjectViewerModule;
import mma.utils.XMLUtils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Configs implements ProjectViewerModule {
    private static final String ConfigPath = "/res/Confing.xml";
    private boolean initialized = false;


    @XmlElement
    private static String splashScreenPath = "splash";
    @XmlElement
    private static String dataPath = "splash";
    @XmlElement
    private static String resourcesPath = "res";
    @XmlElement
    private static String[] imageExtensions = {"png", "jpg"};
    @XmlElement
    private static String[] txtExtensions = {"txt"};

    // Accessors


    public static String getResourcesPath() {
        return resourcesPath;
    }

    public static void setResourcesPath(String resourcesPath) {
        Configs.resourcesPath = resourcesPath;
    }

    public static String[] getTxtExtensions() {
        return txtExtensions;
    }

    public static void setTxtExtensions(String[] txtExtensions) {
        Configs.txtExtensions = txtExtensions;
    }

    public static String getConfigPath() {
        return ConfigPath;
    }

    public static String getSplashScreenPath() {
        return splashScreenPath;
    }

    public static void setSplashScreenPath(String splashScreenPath) {
        Configs.splashScreenPath = splashScreenPath;
    }

    public static String getDataPath() {
        return dataPath;
    }

    public static void setDataPath(String dataPath) {
        Configs.dataPath = dataPath;
    }

    public static String[] getImageExtensions() {
        return imageExtensions;
    }

    public static void setImageExtensions(String[] imageExtensions) {
        Configs.imageExtensions = imageExtensions;
    }

    // ProjectViewerModule methods
    @Override
    public void Initialize() {
        XMLUtils.saveObject(this, (Class<Configs>) this.getClass(), "src" + ConfigPath);
        XMLUtils.loadObject(this.getClass(), this.getClass().getResource(ConfigPath));

        initialized = false;
    }
}
