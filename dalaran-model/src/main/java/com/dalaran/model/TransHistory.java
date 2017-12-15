package com.dalaran.model;

import java.util.Date;

public class TransHistory extends BaseVO {
	private static final long serialVersionUID = -8981558861852550991L;

    private String code;
    private String market;
    private String stockName;
    private String bordName;//
    private int tradeNum;
    private int tradeMoney;
    private double openPrice;
    private double closePrice;
    private double minPrice;
    private double maxPrice;
    private double swing;
    private double diffRate;
    private double diffMoney;
    private double turnover;
    private Date tradeDate;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMarket() {
		return market;
	}
	public void setMarket(String market) {
		this.market = market;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getBordName() {
		return bordName;
	}
	public void setBordName(String bordName) {
		this.bordName = bordName;
	}
	public int getTradeNum() {
		return tradeNum;
	}
	public void setTradeNum(int tradeNum) {
		this.tradeNum = tradeNum;
	}
	public int getTradeMoney() {
		return tradeMoney;
	}
	public void setTradeMoney(int tradeMoney) {
		this.tradeMoney = tradeMoney;
	}
	public double getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}
	public double getClosePrice() {
		return closePrice;
	}
	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}
	public double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}
	public double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public double getSwing() {
		return swing;
	}
	public void setSwing(double swing) {
		this.swing = swing;
	}
	public double getDiffRate() {
		return diffRate;
	}
	public void setDiffRate(double diffRate) {
		this.diffRate = diffRate;
	}
	public double getDiffMoney() {
		return diffMoney;
	}
	public void setDiffMoney(double diffMoney) {
		this.diffMoney = diffMoney;
	}
	public double getTurnover() {
		return turnover;
	}
	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}
	public Date getTradeDate() {
		return tradeDate;
	}
	public void setTradeDate(Date tradeDate) {
		this.tradeDate = tradeDate;
	}
}
