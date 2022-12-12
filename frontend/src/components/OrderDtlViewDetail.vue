<template>

    <v-card outlined>
        <v-card-title>
            OrderDtl # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="OrderId" v-model="item.orderId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CustId" v-model="item.custId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CustAddr" v-model="item.custAddr" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CustTel" v-model="item.custTel" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OrderInfo" v-model="item.orderInfo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="TotPrice" v-model="item.totPrice" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'OrderDtlViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/orderDtls/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

