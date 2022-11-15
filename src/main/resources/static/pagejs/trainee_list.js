new Vue({
    el:'#traineediv',
    data:{
        // 查询//
        traineelist:[],
        searchEntity:{},
        //分页//
        pageNum:1,
        pageSize:5,
        pageInfo:{},

    },
    methods:{
        //分页
        pageing: function(pageNum){
            if(pageNum==0){
                pageNum = 1;
            }
            this.pageNum = pageNum;
            this.findAllPage();
        },

        //分页全查
        findAllPage:function () {
            var _this = this;
           var url = "../trainee/findAllPage?pageNum="+this.pageNum+"&pageSize="+this.pageSize;
           axios.post(url,_this.searchEntity).then(function (response) {
                _this.traineelist=response.data.list;
               _this.pageInfo = response.data;
               _this.pageNum = response.data.pageNum;
               _this.pageSize = response.data.pageSize;
           });
        },
    },
    created:function () {
        this.findAllPage();
    }
});