package top.code666.huobi.handle;

import com.fasterxml.jackson.core.type.TypeReference;
import top.code666.huobi.common.entity.BaseApiResponse;
import top.code666.huobi.common.entity.marketdata.*;
import top.code666.huobi.common.utils.ConnectManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName marketdata
 * @Description 行情数据相关API操作
 * @Author Sean
 * @Date 2019/4/9 21:28
 **/
public class MarketData {
    private ConnectManager cm = ConnectManager.getInstant();

    /**
     * @Author Sean
     * @Description K线数据 , 此接口会返回数据流
     * @Date 23:37 2019/4/10
     * @Param [symbol, period, size] [交易对,数据时间粒度, K 线数据条数]
     * symbol - btcusdt, ethbtc...
     * period - 1min, 5min, 15min, 30min, 60min, 1day, 1mon, 1week, 1year
     * size - [1, 2000]
     * @return top.code666.huobi.common.entity.marketdata.KLine
    **/
    public BaseApiResponse getKLine(String symbol, String period, String size){
        Map<String,String> params = new HashMap<>();
        params.put("symbol",symbol);
        params.put("period",period);
        params.put("size",size);
        BaseApiResponse<List<KLine>> resp =
                cm.get("/market/history/kline", params, new TypeReference<BaseApiResponse<List<KLine>>>() {
                });
        return resp;
    }

    /**
     * @Author Sean
     * @Description 聚合行情 - 暂未测
     * @Date 0:09 2019/4/11
     * @Param [symbol]
     * @return top.code666.huobi.common.entity.BaseApiResponse
    **/
    public BaseApiResponse getMergedDetails(String symbol){
        Map<String,String> params = new HashMap<>();
        params.put("symbol",symbol);
        BaseApiResponse<List<Ticker>> resp =
                cm.get("/market/detail/merged", params, new TypeReference<BaseApiResponse<List<Ticker>>>() {
                });
        return resp;
    }

    /**
     * @Author Sean
     * @Description 所有交易对的最新Tickers - 暂未测
     * @Date 0:13 2019/4/11
     * @Param []
     * @return top.code666.huobi.common.entity.BaseApiResponse
    **/
    public BaseApiResponse getNewTickers(){
        return cm.get("/market/tickers", null, new TypeReference<BaseApiResponse<List<Tickers>>>() {
        });
    }

    /**
     * @Author Sean
     * @Description 获取指定交易对最新的一个交易记录 - 暂未测
     * @Date 0:17 2019/4/11
     * @Param [symbol]
     * @return top.code666.huobi.common.entity.BaseApiResponse
    **/
    public BaseApiResponse getNewTrade1(String symbol){
        Map<String,String> param = new HashMap<>();
        param.put("symbol",symbol);
        BaseApiResponse<Trade1> resp =
                cm.get("/market/trade", param, new TypeReference<BaseApiResponse<Trade1>>() {
                });
        return resp;
    }

    /**
     * @Author Sean
     * @Description 获取指定交易近期的所有交易记录 - 暂未测
     * @Date 0:23 2019/4/11
     * @Param [symbol, size]
     * @return top.code666.huobi.common.entity.BaseApiResponse
    **/
    public BaseApiResponse getNewTradeAll(String symbol, String size){
        Map<String,String> params = new HashMap<>();
        params.put("symbol",symbol);
        params.put("size",size);
        BaseApiResponse<List<TradeAll>> resp =
                cm.get("/market/history/trade", params, new TypeReference<BaseApiResponse<List<TradeAll>>>() {
                });
        return resp;
    }

    /**
     * @Author Sean
     * @Description 获取最近24小时的行情数据汇总 - 暂未测
     * @Date 0:27 2019/4/11
     * @Param [symbol]
     * @return top.code666.huobi.common.entity.BaseApiResponse
    **/
    public BaseApiResponse getTrade24(String symbol){
        Map<String,String> param = new HashMap<>();
        param.put("symbol",symbol);
        BaseApiResponse<Detail24> resp =
                cm.get("/market/detail", param, new TypeReference<BaseApiResponse<Detail24>>() {
                });
        return resp;
    }

}
