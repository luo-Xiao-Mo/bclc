<template>
  <div>
    <b-row>
      <div>
        <b-button v-b-toggle.sidebar-1>能见度工具指标监控</b-button>
        <b-sidebar id="sidebar-1" title="菜单" width="250px">
            <nav-menu></nav-menu>
        </b-sidebar>
      </div>
      <right-container></right-container>
    </b-row>
  </div>

</template>
<script>
  import navMenu from "./pages/navMenu";
  import rightContainer from "./pages/rightContainer";

  export default {
    name:'home',
    components: {
      navMenu:navMenu,
      rightContainer:rightContainer
    },
    data () {
      return{

      }
    },
    methods:{

    }
  }
</script>
