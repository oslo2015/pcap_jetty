package pcap.table;

import pcap.record.UrlRecord;
import pcap.record.UrlRecord.Items;
import pcap.result.UrlLastTime;
import pcap.utils.BasicUtils;
import pcap.utils.PropertyUtils;

import java.util.HashMap;
import java.util.Map;

public class UrlTable {

    /**
     * 用来记录url的表
     * 
     * ip, port, url作为主键， UrlRecord 作为值。其中， ip和port拼成long型作为k1, map->
     * Map<String, UrlRecord> 再利用url -> UrlRecord。
     * 
     * 提供整体的和某个ip或某对ip/port或某个url的相关统计和响应时间
     * */
    private static UrlTable single;

    private Map<Long, Map<String, UrlRecord>> map;

    private UrlTable() {
        map = new HashMap<Long, Map<String, UrlRecord>>();
    }

    /* 单例 */
    public static UrlTable getInstance() {
        if (null == single) {
            synchronized (UrlTable.class) {
                if (null == single) {
                    single = new UrlTable();
                }
            }
        }
        return single;
    }

    /**
     * 在UrlTable中， 查找 ip, port, url对应的记录
     * 
     * @return 存在记录则返回该记录；否则新建一个记录加入到表中并返回该记录。如果又不符合条件的，则返回null
     * */
    public UrlRecord getUrlRecord(int ip, int port, String url) {
        UrlRecord record = null;
        if (!PropertyUtils.isPortValid(port) || BasicUtils.isStringBlank(url))
            return null;

        long key = BasicUtils.ping2Int(ip, port);
        Map<String, UrlRecord> tmp = map.get(key);
        if (null == tmp) {
            tmp = new HashMap<String, UrlRecord>();
            record = new UrlRecord(ip, port, url);
            tmp.put(url, record);
        } else {
            record = tmp.get(url);
            if (null == record) {
                record = new UrlRecord(ip, port, url);
                tmp.put(url, record);
            }
        }
        return record;
    }

    /* 整体查找 */
    /**
     * 获得所有item属性的个数
     * */
    public int getCount(Items item) {
        if (null == item || Items.OTHER == item)
            return 0;
        int cnt = 0;
        for (Map<String, UrlRecord> subMap : map.values()) {
            for (UrlRecord record : subMap.values()) {
                cnt += record.getItemCount(item);
            }
        }
        return cnt;
    }

    /**
     * 返回所有url的平均响应时间
     * */
    public double getAvgTime() {
        long time = 0;
        long cnt = 0;
        for (Map<String, UrlRecord> subMap : map.values()) {
            for (UrlRecord record : subMap.values()) {
                time += record.getTotalTime();
                cnt += record.getTotalCount();
            }
        }
        if (cnt > 0)
            return (time * 1.0) / cnt;
        return 0.0;
    }

    /* 根据url查找 */
    public int getUrlCount(String url, Items item) {
        if (BasicUtils.isStringBlank(url) || null == item || Items.OTHER == item)
            return 0;
        int cnt = 0;
        for (Map<String, UrlRecord> subMap : map.values()) {
            UrlRecord record = subMap.get(url);
            if (null == record)
                continue;
            cnt += record.getItemCount(item);
        }
        return cnt;
    }

    public double getUrlAvgTime(String url) {
        long time = 0;
        long cnt = 0;
        for (Map<String, UrlRecord> subMap : map.values()) {
            UrlRecord record = subMap.get(url);
            if (null == record)
                continue;
            time += record.getTotalTime();
            cnt += record.getTotalCount();
        }
        if (cnt > 0)
            return (time * 1.0) / cnt;
        return 0.0;
    }

    /* 根据ip查找 */
    public int getIpCount(int ip, Items item) {
        if (null == item || Items.OTHER == item)
            return 0;
        int cnt = 0;
        for (Long ipPort : map.keySet()) {
            if (ip != BasicUtils.getHigh4BytesFromLong(ipPort))
                continue;
            Map<String, UrlRecord> subMap = map.get(ipPort);
            for (UrlRecord record : subMap.values()) {
                cnt += record.getItemCount(item);
            }
        }
        return cnt;
    }

    public double getIpAvgTime(int ip) {
        long time = 0;
        long cnt = 0;
        for (Long ipPort : map.keySet()) {
            if (ip != BasicUtils.getHigh4BytesFromLong(ipPort))
                continue;
            Map<String, UrlRecord> subMap = map.get(ipPort);
            for (UrlRecord record : subMap.values()) {
                time += record.getTotalTime();
                cnt += record.getTotalCount();
            }
        }
        if (cnt > 0)
            return (time * 1.0) / cnt;
        return 0.0;
    }

    /* 根据ip/port查找 */
    public int getIpPortCount(int ip, int port, Items item) {
        if (PropertyUtils.isPortValid(port) || null == item || Items.OTHER == item)
            return 0;
        int cnt = 0;
        long key = BasicUtils.ping2Int(ip, port);
        Map<String, UrlRecord> subMap = map.get(key);
        if (null == subMap)
            return 0;
        for (UrlRecord record : subMap.values()) {
            cnt += record.getItemCount(item);
        }
        return cnt;
    }

    public double getIpPortAvgTime(int ip, int port) {
        if (PropertyUtils.isPortValid(port))
            return 0.0;
        long time = 0;
        long cnt = 0;
        long key = BasicUtils.ping2Int(ip, port);
        Map<String, UrlRecord> subMap = map.get(key);
        if (null == subMap)
            return 0.0;
        for (UrlRecord record : subMap.values()) {
            time += record.getTotalTime();
            cnt += record.getTotalCount();
        }
        if (cnt > 0)
            return (time * 1.0) / cnt;
        return 0.0;
    }

    /* 根据ip/port/url查找 */
    public int getIpPortCount(int ip, int port, String url, Items item) {
        if (PropertyUtils.isPortValid(port) || BasicUtils.isStringBlank(url))
            return 0;
        int cnt = 0;
        long key = BasicUtils.ping2Int(ip, port);
        Map<String, UrlRecord> subMap = null;
        UrlRecord record = null;
        if (null == (subMap = map.get(key)) || null == (record = subMap.get(url)))
            return 0;
        cnt = record.getItemCount(item);
        return cnt;
    }

    public double getIpPortAvgTime(int ip, int port, String url) {
        if (PropertyUtils.isPortValid(port) || BasicUtils.isStringBlank(url))
            return 0.0;
        long time = 0;
        long cnt = 0;
        long key = BasicUtils.ping2Int(ip, port);
        Map<String, UrlRecord> subMap = null;
        UrlRecord record = null;
        if (null == (subMap = map.get(key)) || null == (record = subMap.get(url)))
            return 0.0;
        time += record.getTotalTime();
        cnt += record.getTotalCount();
        if (cnt > 0)
            return (time * 1.0) / cnt;
        return 0.0;
    }

    public UrlLastTime getLastTime(int ip, int port, String url) {
        UrlLastTime re = null;
        if (PropertyUtils.isPortValid(port) || BasicUtils.isStringBlank(url))
            return null;

        long key = BasicUtils.ping2Int(ip, port);
        Map<String, UrlRecord> subMap = null;
        UrlRecord record = null;
        if (null == (subMap = map.get(key)) || null == (record = subMap.get(url)))
            return null;
        re = new UrlLastTime(record.getLastTimeStamp(), record.getLastTime());
        return re;
    }
}
