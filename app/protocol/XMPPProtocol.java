package protocol;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.enernoc.open.oadr2.model.EiEvent;
import org.enernoc.open.oadr2.model.OadrCreatedEvent;
import org.enernoc.open.oadr2.model.OadrDistributeEvent;
import org.enernoc.open.oadr2.model.OadrRequestEvent;
import org.enernoc.open.oadr2.model.OadrResponse;

import service.XmppService;

public class XMPPProtocol extends BaseProtocol{    
        
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Events");
    static EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    static XmppService xmppService = XmppService.getInstance();  
    
    public XMPPProtocol(){
        this.setProtocolType(ProtocolType.XMPP);
    }
    
    public static void createNewEm(){
        entityManager = entityManagerFactory.createEntityManager();
        if(!entityManager.getTransaction().isActive()){
            entityManager.getTransaction().begin();
        }
    }

    @Override
    public void send(String uri, OadrResponse oadrResponse, String pid) {
        xmppService.sendObjectToJID(oadrResponse, uri, pid);
    }

    @Override
    public void send(String uri, EiEvent eiEvent) {
        xmppService.sendObjectToJID(eiEvent, uri);        
    }

    @Override
    public void send(String uri, OadrDistributeEvent oadrDistributeEvent) {
        xmppService.sendObjectToJID(oadrDistributeEvent, uri);
        
    }

    @Override
    public void send(String uri, OadrCreatedEvent oadrCreatedEvent) {
        xmppService.sendObjectToJID(oadrCreatedEvent, uri);
        
    }

    @Override
    public void send(String uri, OadrRequestEvent oadrRequestEvent) {
        xmppService.sendObjectToJID(oadrRequestEvent, uri);        
    }
    
    @Override
    public void send(String uri, Object oadrObject){
        xmppService.sendObjectToJID(oadrObject, uri);
    }

}