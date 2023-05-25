import implementation.MatrixAggregator;
import implementation.MatrixAggregatorFactory;
import interfaces.MatrixAggregatorFactoryInterface;
import interfaces.MatrixAggregatorInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.List;

public class RMIClient {
    public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException {
        System.out.println("Hello world!");

        System.setSecurityManager(new SecurityManager());

        List<List<Integer>> matrixA = List.of(List.of(1,0,0),List.of(0,1,0),List.of(0,0,1),List.of(1,0,0),List.of(0,1,0),List.of(0,0,1));
        List<List<Integer>> matrixB1 = List.of(List.of(1,2),List.of(4,1),List.of(8,0));
        List<List<Integer>> matrixB2 = List.of(List.of(3,4),List.of(6,4),List.of(1,4));
        List<List<Integer>> matrixB3 = List.of(List.of(3),List.of(6),List.of(1));
        List<List<Integer>> matrixB4 = List.of(List.of(4),List.of(4),List.of(4));

        MatrixAggregatorFactoryInterface agfactory = (MatrixAggregatorFactoryInterface) Naming.lookup("agfactory");
        MatrixAggregatorInterface matrixAggregatorInterface1 = agfactory.newAggregator(matrixA, matrixB1);
        MatrixAggregatorInterface matrixAggregatorInterface2 = agfactory.newAggregator(matrixA, matrixB2);
        MatrixAggregatorInterface matrixAggregatorInterface3 = agfactory.newAggregator(matrixA, matrixB3);
        MatrixAggregatorInterface matrixAggregatorInterface4 = agfactory.newAggregator(matrixA, matrixB4);

        System.out.println(matrixAggregatorInterface1.getResult());
        System.out.println(matrixAggregatorInterface2.getResult());
        System.out.println(matrixAggregatorInterface3.getResult());
        System.out.println(matrixAggregatorInterface4.getResult());



        /*MatrixAggregatorInterface matrixAggregatorInterface= new MatrixAggregator(matrixA,matrixB);
        System.out.println(matrixAggregatorInterface.getResult());*/
    }
}