package ch19.ex06;

/**
 * リスト19.18 Frameworksクラス
 * @author shuji.w6e
 */
public class Frameworks {

    public static boolean isSupport(ApplicationServer appServer, Database db) {
        switch (appServer) {
        case GlassFish:
            return true;
        case Tomcat:
            return db == Database.MySQL;
        case JBoss:
            return db == Database.DB2 || db == Database.PostgreSQL;
        default:
            return false;
        }
    }

}
