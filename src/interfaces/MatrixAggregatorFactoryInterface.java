package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface MatrixAggregatorFactoryInterface extends Remote {
    MatrixAggregatorInterface newAggregator(List<List<Integer>> matrixA, List<List<Integer>> matrixB) throws RemoteException;
}
