package ru.spbu.apmath.prog.methods;


class GradientDescent {

    Vector gradientDescent(Vector v, Func func) {
        Vector grad = func.grad(v);
        double epsilon = 0.0011;
        int i = 0;
        while (grad.getNorm() > epsilon) {
            double lambda, x1, x2, mid;
            double a = 0;
            double b = 10;
            double delta = 0.0005;
            do {
                mid = (a + b) / 2;
                x1 = mid - delta;
                x2 = mid + delta;
                double i1 = func.val(v.substractV(grad.multiplyV(x1)));
                double i2 = func.val(v.substractV(grad.multiplyV(x2)));
                if (i1 < i2) {
                    b = x2;
                } else {
                    a = x1;
                }
            } while (Math.abs(b - a) > epsilon);
            lambda = (a + b) / 2;
            v = v.substractV(grad.multiplyV(lambda));
            grad = func.grad(v);
            i++;
        }
        System.out.println(i + " итераций");
        return v;
    }
}
