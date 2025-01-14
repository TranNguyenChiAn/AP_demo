package junit;

import org.decimal4j.util.DoubleRounder;

public class HinhChuNhat {
    private double chieuDai;
    private double chieuRong;

    public HinhChuNhat() {
        this.chieuDai = 1.0;
        this.chieuRong = 1.0;
    }

    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public double getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(double chieuDai) {
        if (chieuDai <= 0) {
            throw new RuntimeException("Canh khong am");
        }
        this.chieuDai = chieuDai;
    }

    public double getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(double chieuRong) {
        this.chieuRong = chieuRong;
    }

    public double dienTich() {
        double dt = chieuRong * chieuDai;
        return DoubleRounder.round(dt, 2);
    }

    public double chuVi() {
        double cv = (chieuDai + chieuRong) * 2;
        return DoubleRounder.round(cv, 2);
    }

    @Override
    public String toString() {
        return "HinhChuNhat{" +
                "chieuDai=" + chieuDai +
                ", chieuRong=" + chieuRong +
                '}';
    }
}
