package implementation;

import interfaces.MatrixAggregatorFactoryInterface;
import interfaces.MatrixAggregatorInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class MatrixAggregatorFactory extends UnicastRemoteObject implements MatrixAggregatorFactoryInterface {
    public MatrixAggregatorFactory() throws RemoteException {
        super();
    }
    public MatrixAggregatorInterface newAggregator(List<List<Integer>> matrixA, List<List<Integer>> matrixB) throws RemoteException {
        return new MatrixAggregator(matrixA,matrixB);
    }
}
