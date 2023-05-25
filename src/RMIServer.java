import implementation.MatrixAggregator;
import implementation.MatrixAggregatorFactory;
import interfaces.MatrixAggregatorFactoryInterface;
import interfaces.MatrixAggregatorInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;

public class RMIServer {
    public static void main(String[] args) throws RemoteException, MalformedURLException {


    /*    MatrixAggregatorInterface matrixAggregatorInterface= new MatrixAggregator(matrixA,matrixB);
        System.out.println(matrixAggregatorInterface.getResult());*/
        LocateRegistry.createRegistry(1099);
        MatrixAggregatorFactoryInterface matrixAggregatorFactoryInterface = new MatrixAggregatorFactory();
        Naming.rebind("agfactory",matrixAggregatorFactoryInterface);
        System.out.println("Server Ready");
    }
}
