package implementation;

import interfaces.MatrixAggregatorInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MatrixAggregator extends UnicastRemoteObject implements MatrixAggregatorInterface {

    private List<List<Integer>> matrixA;
    private List<List<Integer>> matrixB;

    public MatrixAggregator(List<List<Integer>> matrixA, List<List<Integer>> matrixB ) throws RemoteException{
        super();
        this.matrixA = matrixA;
        this.matrixB = matrixB;
    }

    public List<List<Integer>> getMatrixA() {
        return matrixA;
    }

    public void setMatrixA(List<List<Integer>> matrixA) {
        this.matrixA = matrixA;
    }

    public List<List<Integer>> getMatrixB() {
        return matrixB;
    }

    public void setMatrixB(List<List<Integer>> matrixB) {
        this.matrixB = matrixB;
    }

    public List<List<Integer>> getResult() throws RemoteException{
        if(matrixA.size() == 0 || matrixB.size() == 0){
            throw new RemoteException("Invalid Dimension");
        }
        if(matrixA.get(0).size() !=  matrixB.size()){
            throw new RemoteException("Cannot compute product of A and B");
        }
        List<List<Integer>> result = new ArrayList<>(matrixA.size());
        for(int i = 0;i < matrixA.size();i++){
            ArrayList<Integer> newrow = new ArrayList<>(matrixB.get(0).size());
            for(int j = 0;j < matrixB.get(0).size();j++){
                int cij = 0;
                for(int k = 0;k <  matrixA.get(i).size();k++){
                    cij += matrixA.get(i).get(k)*matrixB.get(k).get(j);
                }
                newrow.add(cij);
            }
            result.add(newrow);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MatrixAggregator that)) return false;
        return Objects.equals(getMatrixA(), that.getMatrixA()) && Objects.equals(getMatrixB(), that.getMatrixB());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMatrixA(), getMatrixB());
    }
}
