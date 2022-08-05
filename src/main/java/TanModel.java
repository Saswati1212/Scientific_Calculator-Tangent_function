public class TanModel {

	/**
	 * This class is for all tangent function.
	 * 
	 * @author Saswati Chowdhury
	 */


	private double angleForTan;
    private final static double PI = 3.14159265358979323846;

	/**
	 * This function is for validating user input
	 */
	public void setAngleForCalculator(String inputFromUser) {
        try {
			this.angleForTan = Double.parseDouble(inputFromUser);
        } catch (NumberFormatException ex) {
			throw new NumberFormatException("User input is not correct. Please enter a valid angle");
        }
    }

	/**
	 * This function defines tangent function
	 */

	public double calculateTanFunction() throws Exception {

		return tangent(this.angleForTan);
    }

	/**
	 * This function defines Sin-Cos calculation
	 */

	public double sinCosCalculating() throws Exception {
		return sinCosApprox(this.angleForTan);
    }

	/**
	 * This function defines power calculation for Taylor Series
	 */
	public static double powerCalculation(double x, double n)
    {
		double inTotal = 1;
        for(int i = 0; i < n; i++)
        {
			inTotal = x * inTotal;
        }
		return inTotal;


    }

    /*
	 * This function is to calculate tangent of the given angle
	 * 
	 * @param user input
	 * 
	 * @return output of the tangent result
	 */

	public double tangent(double t) throws Exception {

        try {
			if (!(t >= 0.0 && t <= 180.0)) {
                
				int calc = (int) t / 180;
				t = t - (180.0 * calc);
            }
			if (t == 90.0) {
                
                return Double.NaN;
            }
			if (t > 90.0 && t <= 180.0) {
               
				t = t - 180.0;
            }

			int a = 1;
			if (t < 0) {
               
				a = -1;
            }
			if (Math.abs(t) > 45.0 && Math.abs(t) < 90.0) {
               
				return (a) * (1 / tangent(90.0 - Math.abs(t)));
            }

			if (Math.abs(t) >= 22.5 && Math.abs(t) <= 45.0) {
                
				double res = tangent(Math.abs(t) / 2);
				return a * ((2 * res) / (1 - powerCalculation(res, 2)));
            }
			if (Math.abs(t) >= 0 && Math.abs(t) <= 22.5) {
             
				double rad = Math.abs(t) * (PI / 180);
				double result = rad + (powerCalculation(rad, 3) / 3) + (2 * powerCalculation(rad, 5) / 15)
						+ (17 * powerCalculation(rad, 7) / 315);
				return (a) * result;
            }
        } catch (Exception ex) {
			throw new Exception("An error occurred when computing the tan (x). Please try again. ");
        }
        return Double.NaN;
    }

	/**
	 * This function computes factorial value
	 */

	public static double fact(double f) {
		if (f <= 1) {
			return 1;
		} else {
			return f * fact(f - 1);
		}
    }

	/**
	 * This method is for cos(x) using factorial
	 * 
	 * @param input user input
	 * @return output of the computation
	 */

    public static double cosApprox(double x){
		double sol = 1;
		double term = 1;
		int num = 1;
		for (int i = 1; i < (2 * 20); ++i) {
			term *= x / i;
            if(i % 2 == 0){
				++num;
				if (num % 2 == 0) {
					sol -= term;
                }
                else{
					sol += term;
                }
            }
        }
		System.out.println("cos:" + sol);
		return sol;
    }

	/**
	 * This method is for sin(x) using factorial
	 * 
	 * @param input user input
	 * @return output of the computation
	 */

    public static double sinApprox(double x) {
        if (x == Double.NEGATIVE_INFINITY || !(x < Double.POSITIVE_INFINITY)) {
            return Double.NaN;
        }
        x %= 2 * PI;
        if (x < 0) {
            x = 2 * PI - x;
        }
        int sign = 1;
        if (x > PI) {
            x -= PI;
            sign = -1;
        }
		final int prec = 30;
		double temp_prec = 0;
		for (int i = 0; i <= prec; i++) {
			temp_prec += powerCalculation(-1, i) * (powerCalculation(x, 2 * i + 1) / fact(2 * i + 1));
        }
		System.out.println("csin:" + (sign * temp_prec));
		return sign * temp_prec;
    }

	/**
	 * This method computes sin(x) value
	 * 
	 * @param input user input
	 * @return output of the computation
	 */

	public static double sinVal(double deg) {
		double rad = (deg * 1. / 180. * PI) % (2 * PI);
		double sum = rad;
		for (int i = 1; i <= 11; i++) {
			if (i % 2 == 0) {
				sum += powerCalculation(rad, 2 * i + 1) / fact(2 * i + 1);
			} else {
				sum -= powerCalculation(rad, 2 * i + 1) / fact(2 * i + 1);
			}
		}
		return sum;
	}

	/**
	 * This method computes cos(x) function
	 * 
	 * @param input user input
	 * @return output of the computation
	 */

	public static double cosCalculate(double deg) {
		double rad = (deg * 1. / 180. * PI) % (2 * PI);
		double sumCos = 1.0;
		for (int i = 1; i <= 14; i++) {
			if (i % 2 == 0) {
				sumCos += powerCalculation(rad, 2 * i) / fact(2 * i);
			} else {
				sumCos -= powerCalculation(rad, 2 * i) / fact(2 * i);
			}
		}
		return sumCos;
	}

	/**
	 * This function implements tan calculation using sin(x) and cos(x)
	 */

	public static double sinCosApprox(double x) {
         if (x == 90.0) {
			System.out.println("In 900000");
             return Double.NaN;
         }
			else {
				return sinVal(x) / cosCalculate(x);
			}
    }
}
