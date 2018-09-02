/*
Задача 122: Максимальная подматрица
Задача: дана матрица N*M, состоящая из целых чисел. 
Необходимо определить подматрицу с максимальной суммой элементов в ней. 
Входные данные: arr - матрица N*M, элементы матрицы целые числа по модулю меньше 1000. 
N,M - от 1 до 1000.
Вывод: максимальная сумма в подматрице исходной матрицы arr, а также координаты этой подматрицы.
Пример: 
[ { -1, -2, -3 },
 { 1, 1, -4 },
 { 1, 1, -5 } ]
MaxSum = 4
SubMatrix Coordinate: (2, 1) - (3, 2). (Подматрица с левой верхней вершиной (2,1) и правой нижней (3,2), нумерация с 1)
*/

/*
 * Перебираем всевозможные подматрицы и находим подматрицу с максимальной суммой.
 * */
public class MaxSubMatrix 
{
	private int[][] matrix;
	private int N;
	private int M;
	private int sumSubMatrix;
	private Coord startPoint;
	private Coord endPoint;
	
	public MaxSubMatrix(int[][] matrix) {
		this.matrix = matrix;
		N = matrix.length;
		M = matrix[0].length;
	}
		
	public static class Coord {
		int coord1;
		int coord2;
		
		Coord(int x, int y) {
			this.coord1 = x;
			this.coord2 = y;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj.getClass() != Coord.class) {
				return false;
			}
			Coord comparePoint = (Coord) obj;
			return (comparePoint.coord1 == coord1) && (comparePoint.coord2 == coord2);
		}
		
		@Override
		public String toString() {
			return "Coord [coord1=" + coord1 + ", coord2=" + coord2 + "]";
		}
	}
	
	public void calculate() {
		sumSubMatrix = matrix[0][0];
		startPoint = new Coord(1, 1);
		endPoint = new Coord(1, 1);
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				////				
				for (int l = i; l < N; l++) {
					for (int k = j; k < M; k++) {				
						
						int sum = getSum(new Coord(i, j), new Coord(l, k));
						if (sumSubMatrix < sum) {
							sumSubMatrix = sum;
							startPoint = new Coord(i + 1, j + 1);
							endPoint = new Coord(l + 1, k + 1);
						}
						
					}
				}
				////
			}
		}
	}


	private int getSum(Coord start, Coord end) {
		int sum = 0;
		for (int i = start.coord1; i <= end.coord1; i++) {
			for (int j = start.coord2; j <= end.coord2; j++) {
				sum += matrix[i][j];
			}
			
		}
		return sum;
	}

	public int getSum() {
		return sumSubMatrix;
	}

	public Coord[] getCoords() {		
		return new Coord[] {
				startPoint, 
				endPoint
			};
	}
	
	
    public static void main(String[] args)
    {
    	int[][] arr = new int[][] {{ -1, -2, -3 },
    		{ 1, 1, -4 },
    		{ 1, 1, -5 }};
    	MaxSubMatrix maxSubMatrix = new MaxSubMatrix(arr);
    	maxSubMatrix.calculate();    	
        System.out.println("MaxSum: " + maxSubMatrix.getSum());
        Coord[] coords = maxSubMatrix.getCoords();
        System.out.println("Coords: (" + coords[0].coord1 + ", " + coords[0].coord2 + ") - " +
        		"(" + coords[1].coord1 + ", " + coords[1].coord2 + ")");        
    }
}
