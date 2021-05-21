
var app = new Vue({
    el: '#app',
    data: {
        message: 'Hello world!',
        packets:[
            {
                No:'1',
                Name:'A'
            },
            {
                No:'2',
                Name:'B'
            },
            {
                No:'3',
                Name:'C'
            }
        ],
    },
    methods:{
        show: function(type){
            this.packetInfoFlag=type;
        },
        async getPackets() {
            const result = await axios.get('/packets');           
            if (result.data.status === 200) {
                console.log(result);
                this.packets=result.data.packets;
            } else {
                console.log('获取数据失败');
            }
            
        },
    },
    created(){
        this.getPackets();
    }
});