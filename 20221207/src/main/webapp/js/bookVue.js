/**
 * 
 */

let memberAry = [];

const addComponent = {
	template: `
        <div id="addMember">
            <table class="table">
                <tr>
                    <th>{{idLabel}}</th>
                    <td><input type="text" v-model="mId"></td>
                </tr>
                <tr>
                    <th>{{nameLabel}}</th>
                    <td><input type="text" v-model="mName"></td>
                </tr>
                <tr>
                    <th>{{ageLabel}}</th>
                    <td><input type="text" v-model="mAge"></td>
                </tr>
                <tr>
                    <th>{{telLabel}}</th>
                    <td><input type="text" v-model="mTel"></td>
                </tr>
                <tr>
                    <th>{{addrLabel}}</th>
                    <td><input type="text" v-model="mAddr"></td>
                </tr>
                <tr>
                <td colspan="2">
                    <button v-bind:style="{color: mycolor}" class="btn btn-primary" v-on:click="addMember">회원등록</button>
                    <button v-bind:style="{color: mycolor}" class="btn btn-primary" v-on:click="selectedMemberDel">선택삭제</button>
                </td>
            </tr>
            </table>
        </div>
    `,
	data: function() {
		return {
			idLabel: '회원 아이디',
			nameLabel: '회원 이름',
			ageLabel: '회원 나이',
			telLabel: '회원 연락처',
			addrLabel: '회원 주소',

			mId: 'User1',
			mName: '홍길동',
			mAge: 20,
			mTel: '010-1567-5425',
			mAddr: '대구광역시 수성구',
			members: memberAry,
			mycolor: 'red',

		}
	},
	methods: {
		addMember: function() {
			let params = 'memberId=' + this.mId +
				'&memberName=' + this.mName +
				'&memberAge=' + this.mAge +
				'&memberTel=' + this.mTel +
				'&memberAddress=' + this.mAddr +
				'&memberPassword=' + '1234';
			console.log(params)
			fetch('../memberAddAjax.do', {
				method: 'post',
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded'
				},
				body: params
			})
				.then(resolve => resolve.json())
				.then(result => {
					console.log(result);
					this.members.push(result.data)

				})
				.catch(error => console.log(error))
		},
		selectedMemberDel: function() {
			console.log(this);
			//addComponent. 대상은 listComponetn.에 있뜸
			let targetId = this.$parent.$children[1].targetMember;

			//this.members에 포함된 값과 동일한 것 삭제
			targetId.forEach(tId => {
				fetch('../memberDelAjax.do?memberId=' + tId)
					.then(result => result.json())
					.then(result => {
						// console.log(result)
						if (result.retCode == 'Success') {
							this.members.forEach((member, idx) => {
								console.log(member.memberId)
								if (member.memberId == tId) {
									this.members.splice(idx, 1);
									targetId.length = 0;
								}
							})
						} else {
							alert('[삭제실패] 처리 중 에러 발생');
						}
					})
					.catch(error => console.log(error))
			})
		}
	}

}

const listComponent = {
	template: `
    <div>
    <table class="table">
        <thead>
            <tr>
                <th><input type="checkbox"></th>
                <th>회원아이디</th>
                <th>이름</th>
                <th>나이</th>
                <th>연락처</th>
                <th>주소</th>
                <th>삭제</th>
            </tr>
        </thead>
        
        <tbody>
            <tr v-for="member in members">
                <td><input type="checkbox" v-bind:value="member.memberId" v-model="targetMember"></td>
                <td>{{member.memberId}}</td>
                <td>{{member.memberName}}</td>
                <td>{{member.memberAge}}</td>
                <td>{{member.memberTel}}</td>
                <td>{{member.memberAddress}}</td>
                <td><button v-on:click="deleteMember(member.memberId)">삭제</button></td>
            </tr>
        </tbody>
    </table>
    {{targetMember}}
    </div>

    `,
	data: function() {
		return {
			members: memberAry,
			targetMember: []
		}
	},
	methods: {
		deleteMember: function(id) {
			console.log(id)
			fetch('../memberDelAjax.do?memberId=' + id)
				.then(result => result.json())
				.then(result => {
					console.log(result)
					if (result.retCode == 'Success') {
						this.members.forEach((member, idx) => {
							if (member.memberId == id) {
								this.members.splice(idx, 1);
							}
						})
					} else {
						alert('[삭제실패] 처리 중 에러 발생')
					}
				})
				.catch(error => console.log(error))
		}
	}
}

new Vue({
	el: '#app',
	data: {
		members: memberAry
	},
	components: {
		'add-component': addComponent,
		'list-component': listComponent
	},
	beforeCreate: function() {
		console.log('beforeCreate')
	},
	created: function() {
		console.log('created');
		//bookList를 가져오는 json 
		fetch('../memberListAjax.do')
			.then(resolve => resolve.json())
			.then(result => {
				console.log(result);
				result.forEach(member => {
					this.members.push(member)
				})
				console.log(this.members)
			})
			.catch(reject => {
				console.log(reject)
			})
	},

	beforeMount: function() {
		console.log('beforeMount')

	},

	mounted: function() {
		console.log('mounted')

	}
})