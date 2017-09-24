package com.amaker.wlo;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

import com.amaker.adapters.JsonArrayAdapter;
import com.amaker.util.HttpUtil;

public class OrderActivity extends Activity {
	// ���������б�
	private Spinner tableNoSpinner;
	// ��������˺��µ���ť
	private Button orderBtn, addBtn, startBtn;
	// �����༭��
	private EditText personNumEt;
	// ����б�
	private ListView lv;
	// �������ɵĶ���Id
	private String orderId;
	// ����б��а󶨵�����
	private List data = new ArrayList();
	// ����б��о����������
	private Map map;
	// ListView �� Adapter
	private SimpleAdapter sa;
	// ListView ����ʾ��������
	private String[] from = { "id", "name","num", "price", "remark" };
	// ���õ�TextView Drawable ID
	private int[] to = new int[5];

	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ΪActivity���ý��沼��
		setContentView(R.layout.order);
		
		// ʵ����Spinner
		tableNoSpinner = (Spinner) findViewById(R.id.tableNoSpinner);
		// Ϊ���������б�Spinner������
		
		
		
		// ʵ����������ť
		startBtn = (Button) findViewById(R.id.startButton02);
		// Ϊ������ť���Ӽ�����
		startBtn.setOnClickListener(startListener);
		
		// ʵ������˰�ť
		addBtn = (Button) findViewById(R.id.addMealButton01);
		// Ϊ��˰�ť���Ӽ�����
		addBtn.setOnClickListener(addListener);
			
		// ʵ�����µ���ť
		orderBtn = (Button) findViewById(R.id.orderButton02);
		// Ϊ�µ���ť���Ӽ�����
		orderBtn.setOnClickListener(orderListener);
		
		// ʵ���������༭��
		personNumEt = (EditText) findViewById(R.id.personNumEditText02);
		
		// ʵ����ListView
		lv = (ListView) findViewById(R.id.orderDetailListView01);
		// Ϊ����б�ListView������
		setMenusAdapter();
		//����λ��������ť��ѡ��ʱ����
		tableNoSpinner.setOnItemSelectedListener(
				new OnItemSelectedListener() {

					@Override
					public void onItemSelected(AdapterView<?> parent, View view,
							int position, long id) {
						//��ģ����ȡѡ�е�������¼��ǰ����������ص�JSON����
						JSONObject item = (JSONObject)parent.getItemAtPosition(position);
/*						orderBtn.setEnabled(true);
*/						try {
							
							if(item.getInt("flag")==1)
							{
								startBtn.setEnabled(false); //�ѿ�����ť������
								personNumEt.setText(item.getInt("personNum")+"");
								
							}
							else
							{
								startBtn.setEnabled(true); //�ѿ�����ť������
								personNumEt.setText("");
							}
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub
						
					}
				}		
				
				);
				setTableAdapter();
	}
	
	
	// Ϊ����б�ListView������
	private void setMenusAdapter(){
		// ��ʾ������TextView����
		to[0] = R.id.id_ListView;
		to[1] = R.id.name_ListView;
		to[2] = R.id.num_ListView;
		to[3] = R.id.price_ListView;
		to[4] = R.id.remark_ListView;
		// ʵ��������б�ListView Adapter
		sa = new SimpleAdapter(this, data, R.layout.listview, from, to);
		// ΪListView������
		lv.setAdapter(sa);
	}
	
	
	// Ϊ���������б�Spinner������
	private void setTableAdapter(){
				
		String url = HttpUtil.BASE_URL +"/servlet/CheckTableServlet";
		String result = HttpUtil.queryStringForGet(url);
		try {
			JSONArray tables = new JSONArray(result);
			List<JSONObject> lists = new ArrayList<JSONObject>();
			for(int i=0;i<tables.length();i++)
			{
				lists.add(tables.getJSONObject(i));
			}
			JsonArrayAdapter adapter = new JsonArrayAdapter(this, android.R.layout.simple_spinner_item, android.R.id.text1, lists, "num");
		    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			tableNoSpinner.setAdapter(adapter);
		    
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.e("amaker", "ת�����ݳ���");
		}
		
		
	}
	
	
	// ����������
	private OnClickListener startListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			// ����ʱ��
			String orderTime = sdf.format(date);
			// �����û����ӵ�½�����ļ��л��
			SharedPreferences pres = getSharedPreferences("user_msg",
					MODE_WORLD_READABLE);
			String userId = pres.getString("id", "");
			// ����
			TextView tv = (TextView) tableNoSpinner.getSelectedView();
			String tableId = tv.getText().toString();
			JSONObject selobj =(JSONObject) tableNoSpinner.getSelectedItem();
			try {
				if(selobj.getInt("flag")==1)
				{
					Toast.makeText(OrderActivity.this, "��ǰ���Ѿ����������ܼ�����", Toast.LENGTH_LONG);
					return;
				}
			} catch (JSONException e1) {
				Toast.makeText(OrderActivity.this, "��֤����ʧ�ܣ���", Toast.LENGTH_LONG);
				return;
			}
			// ����
			String personNum = personNumEt.getText().toString();
			// ��������б�
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// �����������
			params.add(new BasicNameValuePair("orderTime", orderTime));
			params.add(new BasicNameValuePair("userId", userId));
			params.add(new BasicNameValuePair("tableId", tableId));
			params.add(new BasicNameValuePair("personNum", personNum));
			UrlEncodedFormEntity entity1=null;
			try {
				 entity1 =  new UrlEncodedFormEntity(params,HTTP.UTF_8);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			// ���������url
			String url = HttpUtil.BASE_URL+"servlet/StartTableServlet";
			// ����������HttpPost
			HttpPost request = HttpUtil.getHttpPost(url);
			// ���ò�ѯ����
			request.setEntity(entity1);
			// �����Ӧ���
			String result= HttpUtil.queryStringForPost(request);
			// ���������ɵĶ���Id����ֵ��ȫ��orderId
			orderId = result;
			Toast.
			makeText(OrderActivity.this, result, Toast.LENGTH_LONG).show();
			startBtn.setEnabled(false);
		}
	};
	

	
	// ���˼�����
	private OnClickListener addListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// ���õ�˷���
			addMeal();
		}
	};
	
	//���˷���
	private void addMeal() {
		// ���LayoutInflaterʵ��
		LayoutInflater inflater = LayoutInflater.from(this);
		// ʵ�����ڵ����Ի��������ӵ���ͼ
		final View v = inflater.inflate(R.layout.order_detail, null);
		// �����ͼ�е�Spinner���󣬲˵������б�
		final Spinner menuSpinner = (Spinner) v.findViewById(R.id.menuSpinner);
		// �����ͼ�е�EditText����,����
		EditText numEt = (EditText) v.findViewById(R.id.numEditText);
		// �����ͼ�е�EditTextʵ������ע
		EditText remarkEt = (EditText) v.findViewById(R.id.add_remarkEditText);
		
		
		
		String url = HttpUtil.BASE_URL +"/servlet/MenuServlet";
		String result = HttpUtil.queryStringForGet(url);
		try {
			JSONArray tables = new JSONArray(result);
			List<JSONObject> lists = new ArrayList<JSONObject>();
			for(int i=0;i<tables.length();i++)
			{
				lists.add(tables.getJSONObject(i));
			}
			JsonArrayAdapter adapter = new JsonArrayAdapter(this, R.layout.spinner_lo, lists, new String[]{"id","name","price"},new int[] {
					R.id.id_TextView01, R.id.price_TextView02,
					R.id.name_TextView03, });
		   
		    menuSpinner.setAdapter(adapter);
		    
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Log.e("amaker", "ת�����ݳ���");
		}
		// ���AlertDialog.Builderʵ��
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder
		// ���ñ���
		.setMessage("���ˣ�")
		// �����Զ�����ͼ
		.setView(v)
		// ����ȷ����ť
		.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					// ȷ����ť�¼�
					public void onClick(DialogInterface dialog, int id) {
						
						// ���ListView�е��Զ�����ͼLinearLayout
						LinearLayout v1 = (LinearLayout) menuSpinner
								.getSelectedView();
						
						// ���TextView���˱��
						TextView id_tv = (TextView) v1
								.findViewById(R.id.id_TextView01);
						// ���TextView���˼۸�
						TextView price_tv = (TextView) v1
								.findViewById(R.id.name_TextView03);
						// ���TextView��������
						TextView name_tv = (TextView) v1
								.findViewById(R.id.price_TextView02);
						// ���EditText��������
						EditText num_et = (EditText) v
								.findViewById(R.id.numEditText);
						// ���EditText���˱�ע
						EditText remark_et = (EditText) v
								.findViewById(R.id.add_remarkEditText);
						// �˱��ֵ
						String idStr = id_tv.getText().toString();
						System.out.println("-------------------->id="+idStr);
						// �˼۸�ֵ
						String priceStr = price_tv.getText().toString();
						System.out.println("-------------------->priceStr="+priceStr);
						// ������ֵ
						String nameStr = name_tv.getText().toString();
						System.out.println("-------------------->name="+nameStr);
						// ������ֵ
						String numStr = num_et.getText().toString();
						System.out.println("-------------------->numStr="+numStr);
						// �˱�עֵ
						String remarkStr = remark_et.getText().toString();
						System.out.println("-------------------->remarkStr="+remarkStr);
						
						// ��װ��Map��
						map = new HashMap();

						map.put("id", idStr);
						map.put("name", nameStr);
						map.put("num", numStr);
						map.put("price",priceStr);
						map.put("remark", remarkStr);
						
						// ���ӵ�ListView
						data.add(map);
						
						// ������TextView
						to[0] = R.id.id_ListView;
						to[1] = R.id.name_ListView;
						to[2] = R.id.num_ListView;
						to[3] = R.id.price_ListView;
						to[4] = R.id.remark_ListView;
						
						// ʵ����SimpleAdapter
						sa = new SimpleAdapter(OrderActivity.this, data,
								R.layout.listview, from, to);
						// ΪListView������
						lv.setAdapter(sa);

					}
				}).setNegativeButton("ȡ��", null);
		AlertDialog alert = builder.create();
		alert.show();
	}
	
	
	
	// �µ�������
	private OnClickListener orderListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			System.out.println("=====================���~");
			// ��������б�
			for (int i = 0; i < data.size(); i++) {
				// ������е��map
				Map map = (Map)data.get(i);
				// ��õ����
				String menuId = (String) map.get("id");
				String num = (String)map.get("num");
				String remark = (String)map.get("remark");
				String myOrderId = orderId;
				
				// ��װ�����������
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				// ���ӵ����������
				params.add(new BasicNameValuePair("menuId", menuId));
				params.add(new BasicNameValuePair("orderId", myOrderId));
				params.add(new BasicNameValuePair("num", num));
				params.add(new BasicNameValuePair("remark", remark));
				UrlEncodedFormEntity entity1=null;
				try {
					 entity1 =  new UrlEncodedFormEntity(params,HTTP.UTF_8);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				// ���������Servlet��url
				String url = HttpUtil.BASE_URL+"servlet/OrderDetailServlet";
				// ���HttpPost����
				HttpPost request = HttpUtil.getHttpPost(url);
				// Ϊ�������ò���
				request.setEntity(entity1);
				// ��÷��ؽ��
				String result= HttpUtil.queryStringForPost(request);
				
				Toast.
				makeText(OrderActivity.this, result, Toast.LENGTH_LONG).show();
				
				finish();
				//
			}
		}
	};
}